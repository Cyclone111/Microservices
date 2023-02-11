package com.example.rating.service.controllers;

import com.example.rating.service.entities.Rating;
import com.example.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @GetMapping("/")
    ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRating());
    }

    @GetMapping("/ratingId/{ratingId}")
    ResponseEntity<Rating> getRatingsByRatingId(@PathVariable(name = "ratingId") String ratingId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingById(ratingId));
    }

    @GetMapping("/userId/{userId}")
    ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable(name = "userId") String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUser(userId));
    }

    @GetMapping("/hotelId/{hotelId}")
    ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable(name = "hotelId") String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotel(hotelId));
    }

    @PostMapping("/save")
    ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
        ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.OK).body(rating);
    }
}
