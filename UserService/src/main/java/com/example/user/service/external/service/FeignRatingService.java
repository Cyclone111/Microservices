package com.example.user.service.external.service;

import com.example.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("RATING-SERVICE")
public interface FeignRatingService {

    @GetMapping("/rating/userId/{userId}")
    List<Rating> getRatings(@PathVariable String userId);
}
