package com.myblog.microservices.userservices.exception;

public class UserAlreadyRegisteredException extends RuntimeException {
	
	public UserAlreadyRegisteredException(String message) {
		super(message);
	}

}
