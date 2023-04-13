package com.hcl.ask_buddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ask_buddy.entity.Joinus;

@Repository
public interface JoinusRepo extends JpaRepository<Joinus, Long> {

}
