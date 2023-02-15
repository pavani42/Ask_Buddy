package com.hcl.ask_buddy.question.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ask_buddy.question.dto.QueAndAns;
import com.hcl.ask_buddy.question.entity.Question;
import com.hcl.ask_buddy.question.service.QuestionImpl;

// Controller for Question API's
@RestController
public class QuestionController {
	@Autowired
	QuestionImpl ques;
	
	// Controller for postQuestion
	@GetMapping("/postQuestion/{id}")
	public Question postQuestion(@PathVariable("id") long id, @RequestParam String category, @RequestParam String sub_Category,@RequestParam String question)
	{
		return ques.postQuestion(id, category, sub_Category, question);
	}
	
	// COntroller for fetching Quesdtion with ID
	@GetMapping("/getQuestion/{ques_id}")
	public Question getQuestion(@PathVariable("ques_id") long ques_id)
	{
		return ques.getQuestion(ques_id);
	}
	
	// Controller for fetching Question by Category
	@GetMapping("/SearchQuestionByCategory/{category}")
	public List<QueAndAns> searchQuestionByCat(@PathVariable("category") String category)
	{
		return ques.searchByCategory(category);
	}
	
	// Controller for fetching Question by Sub-Category
	@GetMapping("/SearchQuestionBySubCategory/{subcat}")
	public List<QueAndAns> searchQuestionBySubcat(@PathVariable("subcat") String subCat)
	{
		return ques.searchBySubCategory(subCat);
	}
	
	// Controller for Fetching Question with KeyWord
	@GetMapping("/SearchQuestionByKeyword/{keyword}")
	public List<QueAndAns> searchByKeyword(@PathVariable("keyword") String Keyword)
	{
		return ques.searchQuestion(Keyword);
	}
	
	// Controller for Deleting Question by ID
	@DeleteMapping("/DeleteQuestion/{id}")
	public boolean deleteQuestion(@PathVariable("id") long id)
	{
		return ques.deleteQuestion(id);
	}
	
	// COntroller for Updating Question by ID
	@PostMapping("/UpdateQuestion/{id}")
	public boolean UpdateQuestion(@PathVariable("id") long id, @RequestParam String question)
	{
		return ques.updateQuestion(id, question);
	}
	
	// Controller for Fetching Latest Questions from DB
	@GetMapping("/GetLatestQuestions")
	public List<QueAndAns> getLatestQuestion()
	{
		return ques.getLatestQuestion();
	}
	
	// Controller for User Posted by User
	@GetMapping("/getQuestionByUser/{userId}")
	public List<QueAndAns> getQuestionByUser(@PathVariable("userId") long userId)
	{
		return ques.getByUser(userId);
	}

}