package com.bridgelabz.demo.controller;
import com.bridgelabz.demo.model.Greeting;
import com.bridgelabz.demo.service.GreetingService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public String getGreeting(){
        return "GET : " + greetingService.getGreeting();
    }

    @PostMapping("/greeting")
    public String postGreeting(){
        return "POST : " + greetingService.getGreeting();
    }

    @PutMapping("/greeting")
    public String putGreeting(){
        return "PUT : " + greetingService.getGreeting();
    }

    @DeleteMapping("/greeting")
    public String deleteGreeting(){
        return "DELETE : " + greetingService.getGreeting();
    }

    //UseCase: 4
    @GetMapping("/greeting/params")
    public String getGreetingParams(@RequestParam(value = "firstName", required = false) String firstName,
                                    @RequestParam(value = "lastName", required = false) String lastName) {
        return greetingService.getGreeting(firstName, lastName);
    }

    //UseCase: 5
    @GetMapping("/greeting/{id}")
    public String getGreetingById(@PathVariable long id) {
        Optional<Greeting> greeting = greetingService.findGreetingById(id);
        if (greeting.isPresent()) {
            return greeting.get().getMessage();
        } else {
            return "Greeting not found";
        }
    }
}