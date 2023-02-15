package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.service.HotelService;
import com.hotel.entity.HotelEntity;
import java.util.*;

@RestController
@RequestMapping("/hotels")
public class HotelController
{
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/")
	public ResponseEntity<HotelEntity> createHotel(@RequestBody HotelEntity hotel)
	{
		HotelEntity newlyHotel = this.hotelService.addHotel(hotel);
		return new ResponseEntity<HotelEntity>(newlyHotel,HttpStatus.CREATED);
	}
	
	
	//Get all hotels
	
	@GetMapping("/")
	public ResponseEntity<List<HotelEntity>> getAllHotels()
	{
		List<HotelEntity> allHotels = this.hotelService.getAllHotels();
		
		return new ResponseEntity<List<HotelEntity>>(allHotels,HttpStatus.OK);
	}
	
	//Get Hotel
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<HotelEntity> getHotel(@PathVariable String hotelId)
	{
		HotelEntity hotel = this.hotelService.getHotel(hotelId);
		
		return new ResponseEntity<HotelEntity>(hotel,HttpStatus.OK);
	}

}
