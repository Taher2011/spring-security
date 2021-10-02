package com.udemy.security.controller;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.security.entity.Account;
import com.udemy.security.service.AccountService;

@RestController
public class AccountController {

	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("/account/{customer-id}")
	public ResponseEntity<Account> getAccountDetails(@PathVariable(name = "customer-id") Integer customerId) {
		Account account = accountService.getAccountDetails(customerId);
		if (ObjectUtils.isNotEmpty(account)) {
			return new ResponseEntity<>(account, HttpStatus.OK);
		}
		return new ResponseEntity<>(new Account(), HttpStatus.OK);
	}

}
