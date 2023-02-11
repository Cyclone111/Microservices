package com.example.hotel.service.services;


import com.example.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    void createHotel(Hotel hotel);

    //get hotel
    Hotel getHotel(String id);

    //get All hotel
    List<Hotel> getAllHotels();

}
