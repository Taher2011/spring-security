package com.udemy.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.security.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

	List<Card> findByCustomerId(int customerId);

}
