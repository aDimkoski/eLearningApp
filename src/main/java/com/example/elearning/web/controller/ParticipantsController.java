package com.example.elearning.web.controller;

import com.example.elearning.service.ResultsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/participants")
public class ParticipantsController {
    private final ResultsService resultsService;

    public ParticipantsController(ResultsService resultsService) {
        this.resultsService = resultsService;
    }

    @GetMapping
    public String courses(Model model){
        model.addAttribute("results",resultsService.findAll());
        return "participants";
    }
}
