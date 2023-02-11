package com.example.user.service.services.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.example.user.service.entities.Hotel;
import com.example.user.service.entities.Rating;
import com.example.user.service.external.service.FeignHotelService;
import com.example.user.service.external.service.FeignRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.service.entities.User;
import com.example.user.service.exception.ResourceNotFoudException;
import com.example.user.service.repository.UserRepository;
import com.example.user.service.services.UserService;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	FeignHotelService feignHotelService;

	@Autowired
	FeignRatingService feignRatingService;

	@Override
	public void saveUser(User user) {
		String id = UUID.randomUUID().toString();
		user.setUid(id);
		userRepository.save(user);
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(String id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoudException());

		List<Rating> ratings = feignRatingService.getRatings(user.getUid());

//		Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/rating/userId/"+user.getUid(), Rating[].class);

		//List<Rating> ratings1 = Arrays.stream(ratings).toList();

		List<Rating> ratingsList = ratings.stream().map(x ->{
			Hotel hotel = feignHotelService.getHotel(x.getHotelId());
//			Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+x.getHotelId(), Hotel.class);
			x.setHotel(hotel);
			return x;
		}).collect(Collectors.toList());
		user.setRatings(ratingsList);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = userRepository.findAll();
		for(User user : users){
			ArrayList<Rating> arrayList = restTemplate.getForObject("http://RATING-SERVICE/rating/userId/"+user.getUid(), ArrayList.class);
			user.setRatings(arrayList);
		}
		return users;
	}

	@Override
	public void delete(String id) {
		userRepository.deleteById(id);
		
	}

}
