package com.stockmanaging.stockmanaging.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiRequestHandler {
	
	@ExceptionHandler(value= {ApiRequestException.class})
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
		
		HttpStatus badRequest = HttpStatus.BAD_REQUEST; 
		
		ApiRequest apiRequest = new ApiRequest(e.getMessage(), badRequest, ZonedDateTime.now());
		
		return new ResponseEntity<>(apiRequest, badRequest);
	}
	
	@ExceptionHandler(value= {ResourceNotFoundException.class})
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e){
		
		HttpStatus notFound = HttpStatus.NOT_FOUND; 
		
		ApiRequest apiRequest = new ApiRequest(e.getMessage(), notFound, ZonedDateTime.now());
		
		return new ResponseEntity<>(apiRequest, notFound);
	}

}
