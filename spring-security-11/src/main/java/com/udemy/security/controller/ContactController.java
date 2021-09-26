package com.udemy.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.security.entity.Contact;
import com.udemy.security.service.ContactService;

@RestController
public class ContactController {

	private final ContactService contactService;

	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}

	@PostMapping("/contact")
	public ResponseEntity<Contact> saveContactInquiryDetails(@RequestBody Contact contact) {
		return new ResponseEntity<>(contactService.saveContactInquiryDetails(contact), HttpStatus.CREATED);
	}

}
