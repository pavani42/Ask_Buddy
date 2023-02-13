package com.hcl.ask_buddy.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hcl.ask_buddy.answer.entity.*;
import com.hcl.ask_buddy.answer.security.AuthenticatedUser;
import com.hcl.ask_buddy.answer.service.AnswerServiceImpl;

import java.util.*;

@RestController
public class AnswerController {
	
	@Autowired
	AnswerServiceImpl answerService;
	
	
	
	@GetMapping("/GetAnswersByQuestion")
	public List<Answers> getAnswersByQuestion(@RequestParam String question)
	{
		return answerService.getAnswers(question);
	}
	
	@GetMapping("/PostAnswer/{id}")
	public Answers postAnswer(@PathVariable("id") long id, @RequestParam String answer, @RequestParam String question)
	{
		return answerService.postAnswer(id, question, answer);
		
	}
	
	@GetMapping("/GetAnswerById/{id}")
	public Answers getAnswerById(@PathVariable("id") long id)
	{
		return answerService.getAnswersById(id);
	}
	
	@PostMapping("/UpdateAnswer")
	public String updateAnswer(@RequestParam long id, @RequestParam String answer)
	{
		return answerService.updateAnswer(id, answer);
	}
	
	@GetMapping("DeleteAnswer/{id}")
	public String deleteAnswer(@PathVariable("id") long id)
	{
		return answerService.deleteAnswer(id);
	}	
}
