package com.rating.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException
{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse>  resourceNotFoundException(ResourceNotFoundException ex)
	{
		String message = ex.getMessage();
		
		APIResponse response = new APIResponse();
		response.setMessage(message);
		response.setStatus(false);
		return new ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND);
	}

}
