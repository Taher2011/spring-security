package com.udemy.security.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

	private String authority;

	private String username;

}