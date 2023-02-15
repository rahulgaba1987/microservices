package com.rating.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "micro_rating")
public class RatingEntity 
{
	@Id
	private String ratingId;
	
	
	private String hotelId;
	private String userId;
	
	@Column(nullable = false,length = 30)
	private int rating;
	private String feedback;
	
	

}
