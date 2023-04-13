package com.hcl.ask_buddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ask_buddy.entity.Joinus;
import com.hcl.ask_buddy.service.JoinusService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/joinUs")
public class JoinusCtrl {

	@Autowired
	private JoinusService juServ;

	// Controller for Join us Registration
	@PostMapping("/register")
	public Joinus register(@RequestBody Joinus addUser) {
		return juServ.register(addUser);
	}

	// Controller for fetching all Joinus data
	@GetMapping("/allData")
	public List<Joinus> getAllData() {
		return juServ.getAllData();
	}

	// Controller for fetching data by SAP ID
	@GetMapping("/{sapId}")
	public Joinus fetchById(@PathVariable long sapId) {
		return juServ.fetchById(sapId);
	}

	// Controller for updating the status of Consulting
	@PutMapping("/update/{sapId}/que_status")
	public Joinus updQueStatus(@PathVariable long sapId, @RequestParam boolean newQueStatus) {
		Joinus updated = juServ.updQueStatus(sapId, newQueStatus);
		return updated;
	}
}
