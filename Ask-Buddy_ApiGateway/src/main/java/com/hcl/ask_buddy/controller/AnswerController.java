package com.hcl.ask_buddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hcl.ask_buddy.service.AnswerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AnswerController {

	// Answer API's
	@Autowired
	AnswerService answerService;

	// Adding Answer Controllerr
	@PostMapping(value = "/postAnswer", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
	public ResponseEntity<?> postAnswers(@RequestParam String answer, @RequestParam String question)
	{
		System.out.println(answer + question);
		return ResponseEntity.ok(answerService.postAnswers(answer, question));
	}

	// Searching Answer by Question Controller
	@GetMapping("/getAnswerByQuestion")
	public ResponseEntity<?> getAnswersByQuestion(@RequestParam String question) 
	{
		return new ResponseEntity<>(answerService.getAnswersByQuestion(question), HttpStatus.OK);
	}

	// Updating Answer Controller
	@PostMapping("/updateAnswer")
	public ResponseEntity<?> updateAnswer(@RequestParam long id, @RequestParam String answer)
	{
		return ResponseEntity.ok(answerService.updateAnswer(id, answer));
	}

	// Deleting Answer Controller
	@DeleteMapping("/answer")
	public ResponseEntity<?> deleteAnswer(@RequestParam long id)
	{
		return ResponseEntity.ok(answerService.deleteAnswer(id));
	}
	
	@GetMapping("/getUserAnswers")
	public ResponseEntity<?> getUserAnswers()
	{
		return ResponseEntity.ok(answerService.getUserAnswers());
	}

}
