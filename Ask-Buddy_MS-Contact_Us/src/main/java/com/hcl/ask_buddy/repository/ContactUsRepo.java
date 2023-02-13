package com.hcl.ask_buddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ask_buddy.entity.ContactUs;

@Repository
public interface ContactUsRepo extends JpaRepository<ContactUs, Long> {

}
