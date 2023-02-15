package com.hotel.exception;

public class ResourceNotFoundException  extends RuntimeException
{
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
	
	public ResourceNotFoundException()
	{
	   System.out.println("Resource Not found exception ");
	}

}
