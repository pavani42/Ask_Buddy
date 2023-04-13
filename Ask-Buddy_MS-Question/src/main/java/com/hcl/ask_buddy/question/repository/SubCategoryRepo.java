package com.hcl.ask_buddy.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ask_buddy.question.entity.Category;
import com.hcl.ask_buddy.question.entity.Sub_Category;

// Sub-Category Repository
@Repository
public interface SubCategoryRepo extends JpaRepository<Sub_Category, Long>{
	@Query("select category from Sub_Category category where category.subcat_name = ?1")
	public Sub_Category getCategory(String category);
	
	@Query("select subCategory from Sub_Category subCategory where subCategory.category.cat_name = ?1")
	public List<Sub_Category> subCategoryList(String category);

}
