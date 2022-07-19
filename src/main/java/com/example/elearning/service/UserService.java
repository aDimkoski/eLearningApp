package com.example.elearning.service;

import com.example.elearning.model.Role;
import com.example.elearning.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username,
                  String password, String repeatPassword, String name, String surname, Role role);

}
