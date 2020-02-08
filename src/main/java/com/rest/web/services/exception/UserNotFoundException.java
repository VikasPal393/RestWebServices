package com.rest.web.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class UserNotFoundException extends RuntimeException {

	private String string;

	public UserNotFoundException(String string) {
		super(string);
	}

	

	
	
}
