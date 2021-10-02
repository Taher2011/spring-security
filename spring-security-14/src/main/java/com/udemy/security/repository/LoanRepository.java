package com.udemy.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.security.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

	List<Loan> findByCustomerIdOrderByStartDateDesc(int customerId);

}
