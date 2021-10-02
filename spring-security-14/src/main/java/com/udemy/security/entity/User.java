package com.udemy.security.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the users database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String username;

	private int enabled;

	private String password;

}