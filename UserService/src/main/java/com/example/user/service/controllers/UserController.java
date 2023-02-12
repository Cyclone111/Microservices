package com.example.user.service.controllers;

import com.example.user.service.entities.Rating;
import com.example.user.service.entities.User;
import com.example.user.service.services.impl.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/{id}")
    @CircuitBreaker(name="ratingHotelCircuit", fallbackMethod = "ratingHotelCircuitMethod")
    ResponseEntity<User> getUser(@PathVariable(name = "id") String id){
        User user = userServiceImpl.getUser(id);
        return ResponseEntity.ok(user);
    }

    //creating fallback method for circuit breaker
    ResponseEntity<User> ratingHotelCircuitMethod(String id, Exception ex){
        logger.info("Fallback is executing because service is down ", ex.getMessage());
        User user = User.builder()
                .name("Dummy")
                .about("nothing")
                .email("dummy@gmail.com")
                .ratings(Arrays.asList(Rating.builder().rating(0).build()))
                .build();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/save")
    ResponseEntity<User> saveUser(@RequestBody User user){
        userServiceImpl.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping("/delete")
    ResponseEntity<String> deleteUser(@PathVariable(name = "id") String id){
        userServiceImpl.delete(id);
        return ResponseEntity.ok(id);
    }

    @RequestMapping("/")
    ResponseEntity<List<User>> getAllUser(){
        List<User> users = userServiceImpl.getAllUser();
        return ResponseEntity.ok(users);
    }

}
