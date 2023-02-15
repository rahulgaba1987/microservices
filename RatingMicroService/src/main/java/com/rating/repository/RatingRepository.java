package com.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.entity.RatingEntity;
import java.util.*;
public interface RatingRepository extends JpaRepository<RatingEntity, String>
{
	//Get all ratings by user id
	List<RatingEntity> findByUserId(String userId);
	
	//Get all ratings by hotel id
	List<RatingEntity> findByHotelId(String hotelId);

}
