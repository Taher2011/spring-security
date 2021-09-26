package com.udemy.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.udemy.security.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

	@Query(value = "from Notice n where CURDATE() BETWEEN noticeBeginDate AND noticeEndDate")
	List<Notice> findAllActiveNotices();

}
