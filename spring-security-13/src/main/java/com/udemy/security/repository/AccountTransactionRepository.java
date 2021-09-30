package com.udemy.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.security.entity.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, String> {

	List<AccountTransaction> findByCustomerIdOrderByTransactionDateDesc(int customerId);

}
