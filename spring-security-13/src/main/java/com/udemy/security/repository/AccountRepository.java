package com.udemy.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.security.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	Account findByCustomerId(Integer customerId);

}
