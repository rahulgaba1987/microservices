package com.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entity.RatingEntity;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController 
{
	@Autowired
	private RatingService ratingService;
	
	//create rating
	
	@PostMapping("/")
	public ResponseEntity<RatingEntity> createRating(@RequestBody RatingEntity rating)
	{
		
		   RatingEntity addRating = this.ratingService.addRating(rating);
		   return new ResponseEntity<RatingEntity>(addRating,HttpStatus.CREATED);
		   
	}
	
	@GetMapping("/")
	public ResponseEntity<List<RatingEntity>> getAllRating()
	{
		
		  List<RatingEntity> allRatings = this.ratingService.getAllRatings();
		  return new ResponseEntity<List<RatingEntity>>(allRatings,HttpStatus.OK);
		   
	}
	
	
	//Get rating by user id
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<RatingEntity>> getRatingByUserId(@PathVariable String userId)
	{
		
	     List<RatingEntity> ratingsByUserId = this.ratingService.getRatingsByUserId(userId);
	     return new ResponseEntity<List<RatingEntity>>(ratingsByUserId,HttpStatus.OK);
		   
	}
	
	//Get rating by hotel id
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<RatingEntity>> getRatingByHotelId(@PathVariable String hotelId)
	{
			
		  List<RatingEntity> ratingsByUserId = this.ratingService.getRatingsByHotelId(hotelId);
		  return new ResponseEntity<List<RatingEntity>>(ratingsByUserId,HttpStatus.OK);
			   
	}

}
