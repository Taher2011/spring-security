package com.udemy.security.service;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import com.udemy.security.entity.Card;
import com.udemy.security.repository.CardRepository;

@Service
public class CardService {

	private final CardRepository cardsRepository;

	public CardService(CardRepository cardsRepository) {
		this.cardsRepository = cardsRepository;
	}

	public List<Card> getCardDetails(Integer customerId) {
		List<Card> cards = cardsRepository.findByCustomerId(customerId);
		if (ObjectUtils.isNotEmpty(cards)) {
			return cards;
		}
		return Collections.EMPTY_LIST;
	}

}
