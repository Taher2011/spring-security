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
 * The persistent class for the account_transactions database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "account_transactions")
public class AccountTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "account_number")
	private int accountNumber;

	@Column(name = "closing_balance")
	private int closingBalance;

	@Column(name = "create_date")
	private LocalDate createDate;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "transaction_amt")
	private int transactionAmt;

	@Column(name = "transaction_date")
	private LocalDate transactionDate;

	@Column(name = "transaction_summary")
	private String transactionSummary;

	@Column(name = "transaction_type")
	private String transactionType;

}