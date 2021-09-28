package com.udemy.security.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the authorities database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "authorities")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	// bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

}