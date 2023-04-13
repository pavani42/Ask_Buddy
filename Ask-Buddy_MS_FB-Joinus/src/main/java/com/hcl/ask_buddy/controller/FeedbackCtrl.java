package com.hcl.ask_buddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ask_buddy.entity.Feedback;
import com.hcl.ask_buddy.service.FeedbackService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/feedBack")
public class FeedbackCtrl {

	@Autowired
	private FeedbackService fbServ;

	// Controller for adding feedback
	@PostMapping("/addFeed")
	public Feedback addFeed(@RequestBody Feedback fbdata) {
		return fbServ.addFeed(fbdata);
	}

	// Fetching all data for feedback
	@GetMapping("/allData")
	public List<Feedback> allFeeds() {
		return fbServ.allFeeds();
	}

	// Fetching data by SAPID
//	@GetMapping("/{sapId}")
//	public Feedback fetchById(@PathVariable long sapId) {
//		return fbServ.fetchById(sapId);
//	}

	// Fetching data by ratings
	@GetMapping("/rating/{rating}")
	public List<Feedback> fetchByRatings(@PathVariable int rating) {
		return fbServ.fetchByRatings(rating);
	}
}
