package com.udemy.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {

	@GetMapping("/user")
	public ResponseEntity<Boolean> getAccountDetails() {
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}

}
