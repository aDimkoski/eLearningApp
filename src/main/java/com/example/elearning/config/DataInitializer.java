package com.example.elearning.config;

import com.example.elearning.model.Role;
import com.example.elearning.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initData() {
        this.userService.register("admin","admin","admin","admin","admin", Role.ROLE_ADMIN);
    }
}
