package com.hcl.ask_buddy.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ask_buddy.entity.ContactUs;
import com.hcl.ask_buddy.service.ContactUsService;

// Controller for ContactUS API's
@RestController
@RequestMapping("/contactUs")
public class ContactUsController {

	@Autowired
	private ContactUsService conServ;

	// Controller for add Query
	@PostMapping("/postQuery")
	public ContactUs addQuery(@RequestBody ContactUs addQue) {
		return conServ.addQuery(addQue);
	}

	// Controller for get all Query
	@GetMapping("/getAllQueries")
	public List<ContactUs> getAllQueries() {
		return conServ.getAllQueries();
	}

	// Controller for get Query by Id
	@GetMapping("/sapId/{sap_Id}")
	public ContactUs searchById(@PathVariable("sap_Id") long sap_Id) {
		return conServ.searchById(sap_Id);
	}

	// Controller for Update status
	@PostMapping("/UpdateQuery")
	public ContactUs updatebyId(@RequestBody ContactUs cus) {
		return conServ.updatebyId(cus);
	}

}
