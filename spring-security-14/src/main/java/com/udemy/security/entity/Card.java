package com.udemy.security.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the cards database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class Card implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "card_id")
	private Integer cardId;

	@Column(name = "amount_used")
	private int amountUsed;

	@Column(name = "available_amount")
	private int availableAmount;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "card_type")
	private String cardType;

	@Column(name = "create_date")
	private LocalDate createDate;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "total_limit")
	private int totalLimit;

}