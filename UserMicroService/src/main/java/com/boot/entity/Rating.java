package com.boot.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Rating 
{
	private String ratingId;
	private String hotelId;
	private String userId;
	private int rating;
	private String feedback;
	private Hotel hotel;
	

}
