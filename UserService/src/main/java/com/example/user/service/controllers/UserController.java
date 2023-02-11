package com.example.user.service.controllers;

import com.example.user.service.entities.User;
import com.example.user.service.payload.ApiResponse;
import com.example.user.service.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/{id}")
    ResponseEntity<User> getUser(@PathVariable(name = "id") String id){
        User user = userServiceImpl.getUser(id);
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
