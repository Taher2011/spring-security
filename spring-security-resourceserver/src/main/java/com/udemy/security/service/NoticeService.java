package com.udemy.security.service;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import com.udemy.security.entity.Notice;
import com.udemy.security.repository.NoticeRepository;

@Service
public class NoticeService {

	private final NoticeRepository noticeRepository;

	public NoticeService(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
	}

	public List<Notice> getNotices() {
		List<Notice> notices = noticeRepository.findAllActiveNotices();
		if (ObjectUtils.isNotEmpty(notices)) {
			return notices;
		}
		return Collections.EMPTY_LIST;
	}

}
