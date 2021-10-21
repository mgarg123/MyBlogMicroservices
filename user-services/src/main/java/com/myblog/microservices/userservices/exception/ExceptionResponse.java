package com.myblog.microservices.userservices.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
	
	private Date timestamp;
	private String message;
	private String details;
	
	

}
