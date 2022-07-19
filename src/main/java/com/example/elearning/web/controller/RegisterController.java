package com.example.elearning.web.controller;

import com.example.elearning.model.Role;
import com.example.elearning.model.exceptions.InvalidArgumentException;
import com.example.elearning.model.exceptions.PasswordsDoNotMatchException;
import com.example.elearning.service.AuthService;
import com.example.elearning.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final AuthService authService;
    private final UserService userService;

    public RegisterController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }
    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        return "register";
    }
    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam(required = false) Role role){
        try {
            Role role1= Role.valueOf("ROLE_USER");
            userService.register(username, password, repeatedPassword, name, surname,role1);
            return "redirect:/login";
        }catch (InvalidArgumentException | PasswordsDoNotMatchException exception){
            return "redirect:/register?error="+exception.getMessage();
        }
    }
}
