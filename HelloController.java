package com.nutri.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Nutri Tracker Backend is running!";
    }

    @GetMapping("/test")
    public String test() {
        return "Test API working";
    }
    
}
