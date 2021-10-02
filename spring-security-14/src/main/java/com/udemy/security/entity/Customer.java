package com.udemy.security.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the customer database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "create_date")
	private LocalDate createDate;

	private String email;

	@Column(name = "mobile_number")
	private String mobileNumber;

	private String name;

	private String pwd;

	private String role;

	// bi-directional many-to-one association to Authority
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<Authority> authorities;

	public Authority addAuthority(Authority authority) {
		getAuthorities().add(authority);
		authority.setCustomer(this);

		return authority;
	}

	public Authority removeAuthority(Authority authority) {
		getAuthorities().remove(authority);
		authority.setCustomer(null);

		return authority;
	}

}