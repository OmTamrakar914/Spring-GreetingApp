package com.bridgelabz.demo.service;
import org.springframework.stereotype.Service;

import com.bridgelabz.demo.model.Greeting;
import com.bridgelabz.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class GreetingService {
    public String getGreeting(){
        return "Hello world";
    }

    @Autowired
    private GreetingRepository greetingRepository;

    public String getGreeting(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            message = "Hello " + firstName;
        } else if (lastName != null) {
            message = "Hello " + lastName;
        } else {
            message = "Hello World";
        }
        saveGreeting(message);
        return message;
    }

    public void saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        greetingRepository.save(greeting);
    }

    public Optional<Greeting> findGreetingById(long id){
        return greetingRepository.findById(id);
    }
}