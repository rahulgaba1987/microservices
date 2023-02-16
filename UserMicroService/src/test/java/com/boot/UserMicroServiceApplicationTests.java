package com.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.boot.entity.Rating;
import com.boot.externalservices.RatingService;

@SpringBootTest
@Service
class UserMicroServiceApplicationTests 
{
	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() 
	{
		Rating rating = Rating.builder()
				                    .userId("").
				                    hotelId("").
				                    ratingId("").
				                    feedback("This is created using feign client").
				                    rating(3).build();
		
		this.ratingService.createRating(rating);
		
		System.out.println("New rating created ");
	}
	
	void createRating()
	{
		
	}

}
