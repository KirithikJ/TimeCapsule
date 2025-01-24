package com.example.TimeCapsule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class TimeCapsuleController {

    @GetMapping("/")
    public String showForm() {
        return "timecapsule";
    }

    @PostMapping("/submit")
    public String submitNote(
            @RequestParam("email") String email,
            @RequestParam("message") String message,
            @RequestParam("deliveryTime") int deliveryTime,
            Model model) {
        
        LocalDateTime deliveryDate = LocalDateTime.now().plusYears(deliveryTime);
        model.addAttribute("email", email);
        model.addAttribute("message", message);
        model.addAttribute("deliveryDate", deliveryDate);
        
        // Here, you'd normally schedule the email logic using a task scheduler
        // or save the information in a database for processing.

        return "success";
    }
}
