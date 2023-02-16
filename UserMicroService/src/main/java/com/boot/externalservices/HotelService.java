package com.boot.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.boot.entity.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService 
{

   @GetMapping("/hotels/{hotelId}")
   public Hotel getHotel(@PathVariable("hotelId") String hotelId);
  
}
