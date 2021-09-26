package com.udemy.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.security.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

}
