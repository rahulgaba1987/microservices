package com.rating.service;

import com.rating.entity.RatingEntity;
import java.util.*;

public interface RatingService
{
	//Add Rating
	public RatingEntity addRating(RatingEntity rating);
	
	//Get all ratings
	public List<RatingEntity> getAllRatings();
	
	
	//Get rating by user id
	public List<RatingEntity> getRatingsByUserId(String userId);
	
	//Get rating by hotel id
	public List<RatingEntity> getRatingsByHotelId(String hotelId);
	
	
	

}
