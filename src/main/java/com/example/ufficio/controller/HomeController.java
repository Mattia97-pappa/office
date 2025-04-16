package com.example.ufficio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

 public class HomeController {
    @GetMapping("/")
    public String home(){
    return "redirect:/employees/all";
    }

    @GetMapping("/login")
    public String viewLogin() {
    
    return "login";
    }
    }
