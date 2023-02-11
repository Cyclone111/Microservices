package com.example.hotel.service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @GetMapping("/")
    ResponseEntity<List<String>> getStaff(){
        return new ResponseEntity<>(Arrays.asList("cat, dog, buffalo"), OK);
    }
}
