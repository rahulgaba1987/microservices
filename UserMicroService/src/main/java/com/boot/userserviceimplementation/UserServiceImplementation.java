package com.boot.userserviceimplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.boot.entity.Hotel;
import com.boot.entity.Rating;
import com.boot.entity.UserEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.externalservices.HotelService;
import com.boot.repository.UserRespository;
import com.boot.service.UserService;

@Service
public class UserServiceImplementation implements UserService
{

	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	Logger  logger =LoggerFactory.getLogger(UserServiceImplementation.class);
	
	@Override
	public UserEntity addUser(UserEntity user) 
	{
		
		return this.userRespository.save(user);
	}

	@Override
	public List<UserEntity> getAllUsers() 
	{
		
		return this.userRespository.findAll();
	}

	@Override
	public UserEntity getUser(String userId)
	{
		if(this.userRespository.existsById(userId))
		{
			UserEntity user= this.userRespository.findById(userId).get();
			//fetch rating of the above user from rating service
			//http://localhost:8083/rating/user/0ddc166e-7aab-4af2-98c0-ec6c4d4c5d89
			
			Rating[] ratingsOfUser = this.restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getUserId(),Rating[].class);
			logger.info("{}",ratingsOfUser);
			
			List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		
			
			
			  List<Rating> ratingList = ratings.stream().map(rating->
			  {
//				  ResponseEntity<Hotel> forEntity = this.restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//				     
//				     Hotel hotel = forEntity.getBody();
				     
				     Hotel hotel = this.hotelService.getHotel(rating.getHotelId());
				     rating.setHotel(hotel);
				    // logger.info("Response Status {} "+forEntity.getStatusCode());
				     logger.info("---Rating {} "+rating.getHotelId());
				     
				     
				     return rating;
			  }
			  ).collect(Collectors.toList());
			
			
			
			
			user.setRatingList(ratingList);
			return user;
		}
		else
		{
			throw new ResourceNotFoundException("User ID is does not exist :"+userId);
		}
	
		
	}

}
