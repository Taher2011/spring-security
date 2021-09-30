package com.udemy.security.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.udemy.security.entity.Contact;
import com.udemy.security.repository.ContactRepository;

@Service
public class ContactService {

	private final ContactRepository contactRepository;

	public ContactService(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	public Contact saveContactInquiryDetails(Contact contact) {
		contact.setContactId(getServiceReqNumber());
		LocalDate date = toLocalDate();
		contact.setCreateDate(date);
		return contactRepository.save(contact);
	}

	private LocalDate toLocalDate() {
		Date input = new Date();
		Instant instant = input.toInstant();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		return zdt.toLocalDate();
	}

	public String getServiceReqNumber() {
		Random random = new Random();
		int ranNum = random.nextInt(999999999 - 9999) + 9999;
		return "SR" + ranNum;
	}

}
