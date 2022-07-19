package com.example.elearning.web.controller;

import com.example.elearning.service.ResultsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;


@Controller
@RequestMapping("/courses")
public class CoursesController {

    private final ResultsService resultsService;

    public CoursesController(ResultsService resultsService) {
        this.resultsService = resultsService;
    }

    @GetMapping
    public String courses(){
        return "courses";
    }


    @GetMapping("/ml")
    public String ml(@RequestParam(required = false)String message, Model model){
        if(message != null) {
            model.addAttribute("messageFlag",true);
            model.addAttribute("message",Integer.parseInt(message));
        }
        return "MachineLearning";
    }

    @PostMapping("/ml")
    public String machineLearning(@RequestParam String one,
                           @RequestParam String two,
                           @RequestParam String three,
                           @RequestParam String four,
                           @RequestParam String five,
                           @RequestParam String six,
                           @RequestParam String seven,
                           @RequestParam String eight,
                           @RequestParam String nine,
                           @RequestParam String ten){
        int points=0;
        if(Objects.equals(one, "a")){
            points+=10;
        }
        if(Objects.equals(two, "a")){
            points+=10;
        }
        if(Objects.equals(three, "a")){
            points+=10;
        }
        if(Objects.equals(four, "a")){
            points+=10;
        }
        if(Objects.equals(five, "a")){
            points+=10;
        }
        if(Objects.equals(six, "a")){
            points+=10;
        }
        if(Objects.equals(seven, "a")){
            points+=10;
        }
        if(Objects.equals(eight, "a")){
            points+=10;
        }
        if(Objects.equals(nine, "a")){
            points+=10;
        }
        if(Objects.equals(ten, "a")){
            points+=10;
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        this.resultsService.save(auth.getName(),String.valueOf(points),"Machine Learning");
        return "redirect:/courses/ml?message="+points;
    }

    @GetMapping("/dl")
    public String dl(@RequestParam(required = false)String message, Model model){
        if(message != null) {
            model.addAttribute("messageFlag",true);
            model.addAttribute("message",Integer.parseInt(message));
        }
        return "DeepLearning";
    }

    @PostMapping("/dl")
    public String deepLearning(@RequestParam String one,
                                  @RequestParam String two,
                                  @RequestParam String three,
                                  @RequestParam String four,
                                  @RequestParam String five,
                                  @RequestParam String six,
                                  @RequestParam String seven,
                                  @RequestParam String eight,
                                  @RequestParam String nine,
                                  @RequestParam String ten){
        int points=0;
        if(Objects.equals(one, "a")){
            points+=10;
        }
        if(Objects.equals(two, "a")){
            points+=10;
        }
        if(Objects.equals(three, "a")){
            points+=10;
        }
        if(Objects.equals(four, "a")){
            points+=10;
        }
        if(Objects.equals(five, "a")){
            points+=10;
        }
        if(Objects.equals(six, "a")){
            points+=10;
        }
        if(Objects.equals(seven, "a")){
            points+=10;
        }
        if(Objects.equals(eight, "a")){
            points+=10;
        }
        if(Objects.equals(nine, "a")){
            points+=10;
        }
        if(Objects.equals(ten, "a")){
            points+=10;
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        this.resultsService.save(auth.getName(),String.valueOf(points),"Deep Learning");
        return "redirect:/courses/dl?message="+points;
    }

    @GetMapping("/ai")
    public String ai(@RequestParam(required = false)String message, Model model){
        if(message != null) {
            model.addAttribute("messageFlag",true);
            model.addAttribute("message",Integer.parseInt(message));
        }
        return "ArtificialIntelligence";
    }

    @PostMapping("/ai")
    public String ArtificialIntelligence(@RequestParam String one,
                               @RequestParam String two,
                               @RequestParam String three,
                               @RequestParam String four,
                               @RequestParam String five,
                               @RequestParam String six,
                               @RequestParam String seven,
                               @RequestParam String eight,
                               @RequestParam String nine,
                               @RequestParam String ten){
        int points=0;
        if(Objects.equals(one, "a")){
            points+=10;
        }
        if(Objects.equals(two, "a")){
            points+=10;
        }
        if(Objects.equals(three, "a")){
            points+=10;
        }
        if(Objects.equals(four, "a")){
            points+=10;
        }
        if(Objects.equals(five, "a")){
            points+=10;
        }
        if(Objects.equals(six, "a")){
            points+=10;
        }
        if(Objects.equals(seven, "a")){
            points+=10;
        }
        if(Objects.equals(eight, "a")){
            points+=10;
        }
        if(Objects.equals(nine, "a")){
            points+=10;
        }
        if(Objects.equals(ten, "a")){
            points+=10;
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        this.resultsService.save(auth.getName(),String.valueOf(points),"Artificial Intelligence");
        return "redirect:/courses/ai?message="+points;
    }

}