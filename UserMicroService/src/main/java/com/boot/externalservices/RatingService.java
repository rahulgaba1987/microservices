package com.boot.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.entity.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService 
{
	
	//get
	
	//post
	@PostMapping("/rating/")
	public ResponseEntity<Rating> createRating(@RequestBody Rating values);
	
	//update
	@PutMapping("/rating/{ratingId}")
	public ResponseEntity<Rating> updateRating(@RequestBody Rating values,@PathVariable String ratingId);
	
	@DeleteMapping("/rating/{ratingId}")
	public Rating deleteRating(@PathVariable String ratingId);
}
