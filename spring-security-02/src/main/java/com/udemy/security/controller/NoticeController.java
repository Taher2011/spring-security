package com.udemy.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

	@GetMapping("/notice")
	public String getNoticeDetails() {
		return "Notice details from DB";
	}

}
