package com.hcl.ask_buddy.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;

import com.hcl.ask_buddy.dto.*;
import com.hcl.ask_buddy.service.AnswerService;

@RestController
public class AnswerController {
	
	// Answer API's
	@Autowired
	AnswerService answerService;
	
	// Adding Answer Controllerr
	@GetMapping("/PostAnswer")
	public ResponseEntity<?> postAnswers(@RequestParam String answer, @RequestParam String question)
	{
		try
		{
		return ResponseEntity.ok(answerService.postAnswers(answer, question));
		}
		catch(RestClientResponseException e)
		{
			System.out.println(e.getMessage());
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	// Searching Answer by Question Controller
	@GetMapping("/getAnswerByQuestion")
	public List<Answers> getAnswersByQuestion(@RequestParam String question)
	{
		return answerService.getAnswersByQuestion(question);
	}
	
	// Updating Answer Controller
	@PostMapping("/UpdateAnswer")
	public String updateAnswer(@RequestParam long id, @RequestParam String answer)
	{
		return answerService.updateAnswer(id, answer);
	}
	
	// Deleting Answer Controller
	@GetMapping("/DeleteAnswer")
	public String deleteAnswer(@RequestParam long id)
	{
		return answerService.deleteAnswer(id);
	}
	
}
