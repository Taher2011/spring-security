package com.udemy.security.service;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import com.udemy.security.entity.Loan;
import com.udemy.security.repository.LoanRepository;

@Service
public class LoanService {

	private final LoanRepository loanRepository;

	public LoanService(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}

	public List<Loan> getLoanDetails(Integer customerId) {
		List<Loan> loans = loanRepository.findByCustomerIdOrderByStartDateDesc(customerId);
		if (ObjectUtils.isNotEmpty(loans)) {
			return loans;
		}
		return Collections.EMPTY_LIST;
	}

}
