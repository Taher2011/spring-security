package com.udemy.security.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.security.entity.Notice;
import com.udemy.security.service.NoticeService;

@RestController
public class NoticeController {

	private final NoticeService noticeService;

	public NoticeController(NoticeService noticeService) {
		super();
		this.noticeService = noticeService;
	}

	@GetMapping("/notice")
	public ResponseEntity<List<Notice>> getNotices() {
		List<Notice> notices = noticeService.getNotices();
		if (ObjectUtils.isNotEmpty(notices)) {
			return new ResponseEntity<>(notices, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(Collections.EMPTY_LIST, HttpStatus.OK);
		}
	}

}
