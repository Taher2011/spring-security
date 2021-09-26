package com.udemy.security.service;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import com.udemy.security.entity.AccountTransaction;
import com.udemy.security.repository.AccountTransactionRepository;

@Service
public class BalanceService {

	private final AccountTransactionRepository accountTransactionsRepository;

	public BalanceService(AccountTransactionRepository accountTransactionsRepository) {
		this.accountTransactionsRepository = accountTransactionsRepository;
	}

	public List<AccountTransaction> getBalanceDetails(Integer customerId) {
		List<AccountTransaction> accountTransactions = accountTransactionsRepository
				.findByCustomerIdOrderByTransactionDtDesc(customerId);
		if (ObjectUtils.isNotEmpty(accountTransactions)) {
			return accountTransactions;
		}
		return Collections.EMPTY_LIST;
	}

}
