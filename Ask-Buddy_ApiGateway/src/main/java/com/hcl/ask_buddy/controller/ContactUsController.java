package com.hcl.ask_buddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ask_buddy.dto.ContactUs;
import com.hcl.ask_buddy.service.ContactUs_Service;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

@RequestMapping("/contactUs")
public class ContactUsController {
	
	// ContactUs API's
	@Autowired
	ContactUs_Service contactUsService;
	
	// Controller for add Query
	@PostMapping("/postQuery")
	public ContactUs addQuery(@RequestBody ContactUs addQue) {
		return contactUsService.addQuery(addQue);
	}

	// Controller for get all Query
	@GetMapping("/getAllQueries")
	public List<ContactUs> getAllQueries() {
		return contactUsService.getAllQueries();
	}

	// Controller for get Query by Id
	@GetMapping("/sapId/{sap_Id}")
	public ContactUs searchById(@PathVariable("sap_Id") long sap_Id) {
		return contactUsService.getBySapId(sap_Id);
	}

	// Controller for Update status
	@PostMapping("/updateQuery")
	public ContactUs updatebyId(@RequestBody ContactUs cus) {
		return contactUsService.updateQuery(cus);
	}
	
}
