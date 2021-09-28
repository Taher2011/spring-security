package com.udemy.security.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.security.entity.Loan;
import com.udemy.security.service.LoanService;

@RestController
public class LoanController {

	private final LoanService loanService;

	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}

	@GetMapping("/loan/{customer-id}")
	public ResponseEntity<List<Loan>> getLoanDetails(@PathVariable(name = "customer-id") Integer customerId) {
		List<Loan> loans = loanService.getLoanDetails(customerId);
		if (ObjectUtils.isNotEmpty(loans)) {
			return new ResponseEntity<>(loans, HttpStatus.OK);
		}
		return new ResponseEntity<>(Collections.EMPTY_LIST, HttpStatus.OK);
	}

}
