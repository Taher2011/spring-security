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
 * The persistent class for the contact_messages database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "contact_messages")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "contact_id")
	private String contactId;

	@Column(name = "contact_email")
	private String contactEmail;

	@Column(name = "contact_name")
	private String contactName;

	@Column(name = "create_date")
	private LocalDate createDate;

	private String message;

	private String subject;

}