package com.hcl.ask_buddy.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ask_buddy.question.dto.QueAndAns;
import com.hcl.ask_buddy.question.entity.Category;
import com.hcl.ask_buddy.question.entity.Question;
import com.hcl.ask_buddy.question.entity.Sub_Category;
import com.hcl.ask_buddy.question.service.QuestionImpl;

// Controller for Question API's
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {
	@Autowired
	QuestionImpl ques;
	
	// Controller for postQuestion
	@PostMapping("/postQuestion")
	public Question postQuestion(@RequestParam String category, @RequestParam String sub_Category,@RequestParam String question, @RequestParam String questionDescription)
	{
		return ques.postQuestion(category, sub_Category, question, questionDescription);
	}
	
	// COntroller for fetching Question with ID
	@GetMapping("/question/{ques_id}")
	public Question getQuestion(@PathVariable("ques_id") long ques_id)
	{
		return ques.getQuestion(ques_id);
	}
	
	// Controller for fetching Question by Category
	@GetMapping("/searchQuestionByCategory/{category}")
	public List<QueAndAns> searchQuestionByCat(@PathVariable("category") String category)
	{
		return ques.searchByCategory(category);
	}
	
	// Controller for fetching Question by Sub-Category
	@GetMapping("/searchQuestionBySubCategory/{subcat}")
	public List<QueAndAns> searchQuestionBySubcat(@PathVariable("subcat") String subCat)
	{
		return ques.searchBySubCategory(subCat);
	}
	
	
	// Controller for Fetching Question with KeyWord
	@GetMapping("/searchQuestionByKeyword/{keyword}")
	public List<QueAndAns> searchByKeyword(@PathVariable("keyword") String Keyword)
	{
		System.out.println(Keyword);
		return ques.searchQuestion(Keyword);
	}
	
	// Controller for Deleting Question by ID
	@DeleteMapping("/question/{id}")
	public String deleteQuestion(@PathVariable("id") long id)
	{
		return ques.deleteQuestion(id);
	}
	
	// COntroller for Updating Question by ID
	@PostMapping("/updateQuestion/{id}")
	public boolean UpdateQuestion(@PathVariable("id") long id, @RequestParam String question)
	{
		return ques.updateQuestion(id, question);
	}
	
	// Controller for Fetching Latest Questions from DB
	@GetMapping("/latestQuestions")
	public List<QueAndAns> getLatestQuestion()
	{
		System.out.println("comming latest questions");
		return ques.getLatestQuestion();
	}
	
	// Controller for User Posted by User
	@GetMapping("/questionByUser")
	public List<QueAndAns> getQuestionByUser()
	{
		return ques.getByUser();
	}
	
	@GetMapping("/getCategoryList")
	public List<Category> getCategoryList()
	{
		return ques.getCategoryList();
	}
	
	@GetMapping("/getSubCategoryList/{category}")
	public List<Sub_Category> getSubCategoryList(@PathVariable("category") String category)
	{
		return ques.getSubCategoryListByCategory(category);
	}
	
	@GetMapping("/getQuestionsByCategory")
	public List<QueAndAns> getQuestionByCategory(@RequestParam String cat, @RequestParam String subCat)
	{
		return ques.getDataByCategory(cat, subCat);
	}

}
