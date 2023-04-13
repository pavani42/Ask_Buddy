package com.hcl.ask_buddy.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ask_buddy.question.entity.*;

// Category Repository
@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{
	@Query("select category from Category category where category.cat_name = ?1")
	public Category getCategory(String category);
}
