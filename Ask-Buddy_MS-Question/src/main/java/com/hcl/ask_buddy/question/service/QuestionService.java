package com.hcl.ask_buddy.question.service;

import java.util.List;

import com.hcl.ask_buddy.question.dto.QueAndAns;
import com.hcl.ask_buddy.question.entity.*;


public interface QuestionService {
	public Question postQuestion(String cat, String subCat, String question, String questionDescription);
	public Question getQuestion(long id);
	public boolean updateQuestion(long id, String question);
	public String deleteQuestion(long id);
	public List<QueAndAns> searchQuestion(String word);
	public List<QueAndAns> searchByCategory(String Category);
	public List<QueAndAns> searchBySubCategory(String subCat);
	public List<QueAndAns> getLatestQuestion();
	public List<QueAndAns> getByUser();
	public List<Category> getCategoryList();
	public List<Sub_Category> getSubCategoryListByCategory(String cat);
	public List<QueAndAns> getDataByCategory(String cat, String sub_cat);
}
