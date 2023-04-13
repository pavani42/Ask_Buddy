package com.hcl.ask_buddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ask_buddy.entity.*;

// Category Repository
@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{
//	@Query("select Category")
}
