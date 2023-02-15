package com.rating.serviceimplementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entity.RatingEntity;
import com.rating.repository.RatingRepository;
import com.rating.service.RatingService;

@Service
public class RatingServiceImplementation implements RatingService
{
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public RatingEntity addRating(RatingEntity rating) 
	{
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return this.ratingRepository.save(rating);
	}

	@Override
	public List<RatingEntity> getAllRatings() 
	{
		
		return this.ratingRepository.findAll();
	}

	@Override
	public List<RatingEntity> getRatingsByUserId(String userId) {
		
		return this.ratingRepository.findByUserId(userId);
	}

	@Override
	public List<RatingEntity> getRatingsByHotelId(String hotelId) 
	{
		
		return this.ratingRepository.findByHotelId(hotelId);
	}


}
