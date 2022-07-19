package com.example.elearning.service.impl;

import com.example.elearning.model.Role;
import com.example.elearning.model.User;
import com.example.elearning.model.exceptions.InvalidArgumentException;
import com.example.elearning.model.exceptions.PasswordsDoNotMatchException;
import com.example.elearning.model.exceptions.UsernameAlreadyExistsException;
import com.example.elearning.repository.UserRepository;
import com.example.elearning.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String username, String password,
                         String repeatPassword, String name, String surname, Role role) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentException();
        }
        if(!password.equals(repeatPassword)){
            throw new PasswordsDoNotMatchException();
        }

        if(this.userRepository.findByUsername(username).isPresent()){
            throw new UsernameAlreadyExistsException(username);
        }
        User user=new User(username,passwordEncoder.encode(password),name,surname,role);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
    }
}
