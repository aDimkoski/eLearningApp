package com.example.elearning.web.controller;

import com.example.elearning.model.ContactMessages;
import com.example.elearning.service.ContactService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public String contact(Model model, @RequestParam(required = false)String message){
        if(message != null) {
            model.addAttribute("messageFlag",true);
            model.addAttribute("message",message);
        }
        return "contact";
    }

    @GetMapping("/listings")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String listings(Model model){
        List<ContactMessages> messagesList=this.contactService.findAll();
        model.addAttribute("listings",messagesList);
        return "messagesListings";
    }

    @PostMapping
    public String register(@RequestParam String fullName,
                           @RequestParam String email,
                           @RequestParam String phonenumber,
                           @RequestParam String message){
        this.contactService.save(fullName, email, phonenumber, message);
        return "redirect:/contact?message=Message sent successfully.";
    }

}