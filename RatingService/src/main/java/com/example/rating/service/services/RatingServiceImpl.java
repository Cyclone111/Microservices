package com.example.rating.service.services;

import com.example.rating.service.entities.Rating;
import com.example.rating.service.exceptions.ResourceNotFoundException;
import com.example.rating.service.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements  RatingService{

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public List<Rating> getRatingByUser(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotel(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public Rating getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public void saveRating(Rating rating) {
        ratingRepository.save(rating);
    }
}
