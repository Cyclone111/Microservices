package com.example.hotel.service.services;

import com.example.hotel.service.entities.Hotel;
import com.example.hotel.service.exceptions.ResourceNotFoundException;
import com.example.hotel.service.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public void createHotel(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setHotelId(id);
        hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> {throw new ResourceNotFoundException("Hotel not found");});
    }

    @Override
    public List<Hotel> getAllHotels() {

        return hotelRepository.findAll();
    }
}
