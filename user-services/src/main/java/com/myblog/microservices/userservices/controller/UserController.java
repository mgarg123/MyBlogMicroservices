package com.myblog.microservices.userservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.microservices.userservices.exception.UserAlreadyRegisteredException;
import com.myblog.microservices.userservices.exception.UserNotFoundException;
import com.myblog.microservices.userservices.model.User;
import com.myblog.microservices.userservices.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	
//	@PostMapping("/register")
//	public ResponseEntity<User> register(@RequestBody(required = true) User user) {
//		
//		User regUser = userService.registerUser(user);
//		if(regUser==null) {
//			throw new UserAlreadyRegisteredException("User is already regsitered!");
//		}
//		return new ResponseEntity<User>(user, HttpStatus.CREATED);
//	}
//	
//	@PostMapping("/login")
//	public String login() {
//		return "";
//	}
	
	@PostMapping("/forget-password")
	public String forgetPass() {
		return "";
	}
	
	@PostMapping("/forget-username")
	public String forgetUsername() {
		return "";
	}

}
