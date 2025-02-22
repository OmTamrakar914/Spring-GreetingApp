package com.bridgelabz.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private final String message="Hello from bridgeLabz";
    @GetMapping("/greeting")
    public String getGreeting(){
        return "GET : " + message ;
    }

    @PostMapping("/greeting")
    public String postGreeting(){
        return "POST : " + message;
    }

    @PutMapping("/greeting")
    public String putGreeting(){
        return "PUT : " + message;
    }

    @DeleteMapping("/greeting")
    public String deleteGreeting(){
        return "DELETE : " + message;
    }
}