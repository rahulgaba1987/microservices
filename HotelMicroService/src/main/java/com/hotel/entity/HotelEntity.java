package com.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "micro_hotel")
public class HotelEntity 
{
	@Id
	private String hotelId;
	
	@Column(length = 30,nullable = false)
	private String hotelName;
	
	@Column(length = 30,nullable = false)
	private String hotelLocation;
	
	@Column(length = 30,nullable = false)
	private String about;

}
