package com.boot.entity;

import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class Hotel 
{

	private String hotelId;
	
	
	private String hotelName;
	
	
	private String hotelLocation;
	
	
	private String about;

}
