package com.bridgelabz.demo.service;
import org.springframework.stereotype.Service;

import com.bridgelabz.demo.model.Greeting;
import com.bridgelabz.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;

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
    
    public List<Greeting> getAllGreeting(){
        return greetingRepository.findAll();
    }
    
  //UseCase: 7
    public Optional<Greeting> updatingGreeting(long id, String newMessage){
        Optional<Greeting> existingGreeting=greetingRepository.findById(id);
        if(existingGreeting.isPresent()){
            Greeting greeting=existingGreeting.get();
            greeting.setMessage(newMessage);
            greetingRepository.save(greeting);
            return Optional.of(greeting);
        }else{
            return Optional.empty();
        }
    }
    
}