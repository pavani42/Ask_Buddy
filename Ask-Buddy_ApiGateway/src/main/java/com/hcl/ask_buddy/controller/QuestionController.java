package com.hcl.ask_buddy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.hcl.ask_buddy.dto.QueAndAns;
import com.hcl.ask_buddy.dto.Question;
import com.hcl.ask_buddy.service.QuestionService;

@RestController
public class QuestionController {
	
	@Autowired 
	AuthenticationController serverController;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/AddQuestion")
	public String addQuestion(@RequestParam String category, @RequestParam String sub_Category, @RequestParam String question)
	{
		return questionService.addQuestion(category, sub_Category, question);
	}
	
	@GetMapping("/GetQuestionByID")
	public Question getQuestionByID(@RequestParam long id)
	{
		return questionService.getQuestionByID(id);
	}
	
	@GetMapping("/SearchByCategory")
	public List<QueAndAns> getByCategory(@RequestParam String category)
	{
		return questionService.getByCategory(category);
	}
	
	@GetMapping("/SearchBySubCategory")
	public List<QueAndAns> getBySubCategory(@RequestParam String sub_category)
	{
		return questionService.getBySubCategory(sub_category);
	}
	
	@GetMapping("/GetUserQuestions")
	public List<QueAndAns> getUserQuestions()
	{
		return questionService.getUserQuestions();
	}
	
	@GetMapping("/SearchByKeyword")
	public List<ResponseEntity<QueAndAns[]>> getByKeyword(@RequestParam String keyword)
	{
		return questionService.getByKeyword(keyword); 
	}
	
	@GetMapping("/DeleteQuestion")
	public void deleteQuestion(@RequestParam long questionId)
	{
		questionService.deleteQuestion(questionId);
	}
	
	@PostMapping("/updateQuestion")
	public boolean updateQuestion(@RequestParam long quesId, @RequestParam String question)
	{
		return questionService.updateQuestion(quesId, question);
	}
	
	@GetMapping("/getLatestQuestion")
	public List<QueAndAns> getLatestQuestions()
	{
		return questionService.getLatestQuestions();
	}
}
