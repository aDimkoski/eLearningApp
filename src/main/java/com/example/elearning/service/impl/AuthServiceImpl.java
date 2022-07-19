package com.example.elearning.service.impl;

import com.example.elearning.model.User;
import com.example.elearning.model.exceptions.InvalidArgumentException;
import com.example.elearning.model.exceptions.InvalidUserCredentialsException;
import com.example.elearning.repository.UserRepository;
import com.example.elearning.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User login(String username, String password) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentException();
        }
        return userRepository.
                findByUsernameAndPassword(username,password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        return null;
    }
}
