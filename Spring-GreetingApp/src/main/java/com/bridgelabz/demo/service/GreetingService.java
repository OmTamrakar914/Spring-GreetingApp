package com.bridgelabz.demo.service;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreeting(){
        return "Hello world";
    }
    
    //UseCase: 3
    public String displayingGreeting(String firstName,String lastName){
        if(firstName != null && lastName != null){
            return "Hello " + firstName + " " + lastName;
        }
        if(firstName != null){
            return "Hello " + firstName;
        }
        if(lastName != null){
            return "Hello " + lastName;
        }else{
            return "Hello World";
        }
    }
}