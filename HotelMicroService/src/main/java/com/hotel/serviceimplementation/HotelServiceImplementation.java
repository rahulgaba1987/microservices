package com.hotel.serviceimplementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.service.HotelService;
import com.hotel.entity.HotelEntity;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repository.HotelRepository;

@Service
public class HotelServiceImplementation implements HotelService
{
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public HotelEntity addHotel(HotelEntity hotel) 
	{
		String hotelId = UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		return this.hotelRepository.save(hotel);
	}

	@Override
	public List<HotelEntity> getAllHotels()
	{
		
		return this.hotelRepository.findAll();
	}

	@Override
	public HotelEntity getHotel(String hotelId) 
	{
		if(this.hotelRepository.existsById(hotelId))
		{
		return	this.hotelRepository.findById(hotelId).get();
		}
		else
		{
			throw new ResourceNotFoundException("Hotel ID is not found with Id :"+hotelId);
		}
		
	}

	

}
