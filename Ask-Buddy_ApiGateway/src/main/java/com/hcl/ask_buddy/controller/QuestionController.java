package com.hcl.ask_buddy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.hcl.ask_buddy.dto.QueAndAns;
import com.hcl.ask_buddy.dto.Question;
import com.hcl.ask_buddy.service.QuestionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {
	
	// Question API's
	@Autowired 
	AuthenticationController serverController;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	QuestionService questionService;
	
	// Controller for Adding Question
	@PostMapping("/addQuestion")
	public String addQuestion(@RequestParam String category, @RequestParam String sub_Category, @RequestParam String question, @RequestParam String questionDescription)
	{
		return questionService.addQuestion(category, sub_Category, question, questionDescription);
	}
	
	// Controller for Search Question By ID
	@GetMapping("/questionByID")
	public Question getQuestionByID(@RequestParam long id)
	{
		return questionService.getQuestionByID(id);
	}
	
	// Controller for Search by Category
	@GetMapping("/searchByCategory")
	public List<QueAndAns> getByCategory(@RequestParam String category)
	{
		return questionService.getByCategory(category);
	}
	
	// Controller for Search by Sub-Category
	@GetMapping("/searchBySubCategory")
	public List<QueAndAns> getBySubCategory(@RequestParam String sub_category)
	{
		return questionService.getBySubCategory(sub_category);
	}
	
	// Controller for fetching User Questions
	@GetMapping("/userQuestions")
	public List<QueAndAns> getUserQuestions()
	{
		return questionService.getUserQuestions();
	}
	
	// Controller for Searcin by Keyword
	@GetMapping("/searchByKeyword")
	public List<QueAndAns> getByKeyword(@RequestParam String keyword)
	{
		return questionService.getByKeyword(keyword); 
	}
	
	// Controller for Deleting the Question
	@DeleteMapping("/question")
	public ResponseEntity<String> deleteQuestion(@RequestParam long questionId)
	{
		return new ResponseEntity<String>(questionService.deleteQuestion(questionId), HttpStatus.OK);
	}
	
	// Controller for the Updating the Questions
	@PostMapping("/updateQuestion")
	public boolean updateQuestion(@RequestParam long quesId, @RequestParam String question)
	{
		return questionService.updateQuestion(quesId, question);
	}
	
	// Controller for fetching Latest Questions
	@GetMapping("/latestQuestion")
	public List<QueAndAns> getLatestQuestions()
	{
		return questionService.getLatestQuestions();
	}
}
