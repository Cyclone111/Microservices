package com.example.hotel.service.controllers;

import com.example.hotel.service.entities.Hotel;
import com.example.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    //create
    @PostMapping("/save")
    ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        hotelService.createHotel(hotel);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<List<Hotel>> getAllHotel(){
        return  new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Hotel> getHotelById(@PathVariable(name = "id") String id){
        return  new ResponseEntity<>(hotelService.getHotel(id), HttpStatus.OK);
    }

}
