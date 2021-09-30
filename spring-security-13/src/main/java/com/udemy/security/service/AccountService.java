package com.udemy.security.service;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import com.udemy.security.entity.Account;
import com.udemy.security.repository.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public Account getAccountDetails(Integer customerId) {
		Account account = accountRepository.findByCustomerId(customerId);
		if (ObjectUtils.isNotEmpty(account)) {
			return account;
		}
		return new Account();
	}

}
