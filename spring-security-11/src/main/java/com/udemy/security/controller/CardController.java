package com.udemy.security.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.security.entity.Card;
import com.udemy.security.service.CardService;

@RestController
public class CardController {

	private CardService cardService;

	public CardController(CardService cardService) {
		this.cardService = cardService;
	}

	@GetMapping("/card/{customer-id}")
	public ResponseEntity<List<Card>> getCardDetails(@PathVariable(name = "customer-id") Integer customerId) {
		List<Card> cards = cardService.getCardDetails(customerId);
		if (ObjectUtils.isNotEmpty(cards)) {
			return new ResponseEntity<>(cards, HttpStatus.OK);
		}
		return new ResponseEntity<>(Collections.EMPTY_LIST, HttpStatus.OK);
	}

}
