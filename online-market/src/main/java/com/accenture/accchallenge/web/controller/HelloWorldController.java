package com.accenture.accchallenge.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class HelloWorldController {

    @GetMapping
    public String saludar(){
        return "Hello World! Never stop learning! 🚀";
    }
}
