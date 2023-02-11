package com.example.rating.service.services;

import com.example.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {

    //getRatingByUser
    List<Rating> getRatingByUser(String userId);

    //getRatingByHotel
    List<Rating> getRatingByHotel(String hotelId);

    //getRatingByRatingId
    Rating getRatingById(String ratingId);

    //getRating
    List<Rating> getAllRating();

    //save Rating
    void saveRating(Rating rating);
}
