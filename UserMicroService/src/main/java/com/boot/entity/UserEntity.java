package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "micro_user")
public class UserEntity {
	@Id
	private String userId;
	
	@Column(name = "user",length = 30)
	private String userName;
	
	@Column(name = "email",length = 30,nullable = false,unique =true)
	private String userEmail;
	
	@Column(name = "about",length = 30)
	private String about;
	
	@Transient
	public List<Rating> ratingList= new ArrayList<>();
}
