package com.example.pupsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuildController {
    @GetMapping("/")
    public String build(){
        return "build/index";
    }

    @GetMapping("/login")
    public String login(){
        return "build/login";
    }

    @GetMapping("/register")
    public String register(){
        return "build/register";
    }
}
