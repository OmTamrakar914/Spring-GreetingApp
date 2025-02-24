package com.bridgelabz.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.demo.model.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting,Long> {
}