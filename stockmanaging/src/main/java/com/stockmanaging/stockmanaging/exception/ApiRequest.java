package com.stockmanaging.stockmanaging.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiRequest {
	
	private String message;
	
	private HttpStatus httpStatus;
	
	private ZonedDateTime timeStamp;

	public ApiRequest(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public ZonedDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(ZonedDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}


	
	
	
}
