package com.example.elearning.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ourteam")
public class OurTeamController {

    @GetMapping
    public String team(){
        return "ourteam";
    }

}