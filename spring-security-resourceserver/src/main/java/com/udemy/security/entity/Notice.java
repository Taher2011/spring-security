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
 * The persistent class for the notice_details database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="notice_details")
public class Notice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="notice_id")
	private int noticeId;

	@Column(name="create_date")
	private LocalDate createDate;

	@Column(name="notice_begin_date")
	private LocalDate noticeBeginDate;

	@Column(name="notice_details")
	private String noticeDetails;

	@Column(name="notice_end_date")
	private LocalDate noticeEndDate;

	@Column(name="notice_summary")
	private String noticeSummary;

	@Column(name="update_date")
	private LocalDate updateDate;


}