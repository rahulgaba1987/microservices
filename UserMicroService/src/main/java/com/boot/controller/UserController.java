package com.boot.controller;

import java.awt.image.RescaleOp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.UserEntity;
import com.boot.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController 
{
  
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user)
	{
		 String userId = UUID.randomUUID().toString();
		 user.setUserId(userId);
		  UserEntity savedUser = this.userService.addUser(user);
		  return new ResponseEntity<UserEntity>(savedUser,HttpStatus.CREATED);
	}
	
	// Get All users
	@GetMapping("/")
	public ResponseEntity<List<UserEntity>> getAllUsers()
	{
		  List<UserEntity> allUsers = this.userService.getAllUsers();
		  return new ResponseEntity<List<UserEntity>>(allUsers,HttpStatus.OK);
	}
	
	// Get user by Id
	@GetMapping("/{userId}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable("userId") String userId)
    {
	    UserEntity user = this.userService.getUser(userId);
		return new ResponseEntity<UserEntity>(user,HttpStatus.OK);
	}
	
	
	
}
