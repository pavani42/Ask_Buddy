package com.hcl.ask_buddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ask_buddy.entity.Sub_Category;

// Sub-Category Repository
@Repository
public interface SubCategoryRepo extends JpaRepository<Sub_Category, Long>{

}
