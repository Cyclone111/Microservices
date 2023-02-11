package com.example.user.service.external.service;

import com.example.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("HOTEL-SERVICE")
public interface FeignHotelService {

    @GetMapping("/hotels/{userId}")
    Hotel getHotel(@PathVariable String userId);
}
