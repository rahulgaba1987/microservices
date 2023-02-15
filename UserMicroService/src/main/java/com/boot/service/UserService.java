package com.boot.service;

import com.boot.entity.UserEntity;
import java.util.*;

public interface UserService
{
	// Add User
	public UserEntity addUser(UserEntity user);
	
	// Get All Users
	public List<UserEntity> getAllUsers();
	
	// Get User By Id
	public UserEntity getUser(String userId);
	
	// Update User
	
	

}
