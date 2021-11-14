package com.udemy.security.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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

	// bi-directional one-to-many association to Authority
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<Authority> authorities;

	public void addAuthority(Authority authority) {
		if (authorities == null) {
			authorities = new ArrayList<>();
		}
		authorities.add(authority);
	}

	public void removeAuthority(Authority authority) {
		if (authorities == null) {
			authorities = new ArrayList<>();
		}
		authorities.remove(authority);
		authority.setCustomer(null);
	}

}