package com.hcl.ask_buddy.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hcl.ask_buddy.answer.entity.*;
import com.hcl.ask_buddy.answer.service.AnswerServiceImpl;

import java.util.*;

// Answer Controller
@RestController
public class AnswerController {
	
	@Autowired
	AnswerServiceImpl answerService;
	
	
	// Controller for fetching Ans by Question
	@GetMapping("/answersByQuestion")
	public List<Answers> getAnswersByQuestion(@RequestParam String question)
	{
		return answerService.getAnswers(question);
	}
	
	//Controller for publishing answer
	@PostMapping("/postAnswer")
	public Answers postAnswer(@RequestParam String answer, @RequestParam String question)
	{
		return answerService.postAnswer(question, answer);
	}
	
	// Controller for fetching answer by ID
	@GetMapping("/answerById/{id}")
	public Answers getAnswerById(@PathVariable("id") long id)
	{
		return answerService.getAnswersById(id);
	}
	
	// Controller for updating answer by ID
	@PostMapping("/updateAnswer")
	public String updateAnswer(@RequestParam long id, @RequestParam String answer)
	{
		return answerService.updateAnswer(id, answer);
	}
	
	// Controller for deleting answer by ID
	@DeleteMapping("/answer/{id}")
	public String deleteAnswer(@PathVariable("id") long id)
	{
		return answerService.deleteAnswer(id);
	}	
}
