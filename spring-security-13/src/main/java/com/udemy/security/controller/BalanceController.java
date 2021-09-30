package com.udemy.security.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.security.entity.AccountTransaction;
import com.udemy.security.service.BalanceService;

@RestController
public class BalanceController {

	private final BalanceService balanceService;

	public BalanceController(BalanceService balanceService) {
		this.balanceService = balanceService;
	}

	@GetMapping("/balance/{customer-id}")
	public ResponseEntity<List<AccountTransaction>> getBalanceDetails(
			@PathVariable(name = "customer-id") Integer customerId) {
		List<AccountTransaction> accountTransactions = balanceService.getBalanceDetails(customerId);
		if (ObjectUtils.isNotEmpty(accountTransactions)) {
			return new ResponseEntity<>(accountTransactions, HttpStatus.OK);
		}
		return new ResponseEntity<>(Collections.EMPTY_LIST, HttpStatus.OK);
	}
}
