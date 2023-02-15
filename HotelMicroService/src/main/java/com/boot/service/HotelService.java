package com.boot.service;

import com.hotel.entity.HotelEntity;
import java.util.*;

public interface HotelService 
{

	// Add new Hotel
	
	public HotelEntity addHotel(HotelEntity hotel);
	
    // Get all hotels
	public List<HotelEntity> getAllHotels();
	
	
	//Get Hotels by id
	public HotelEntity getHotel(String hotelId);
}
