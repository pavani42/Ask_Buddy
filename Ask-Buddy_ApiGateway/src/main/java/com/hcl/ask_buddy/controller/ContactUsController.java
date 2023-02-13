package com.hcl.ask_buddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ask_buddy.dto.ContactUs;
import com.hcl.ask_buddy.service.ContactUs_Service;

@RestController
@RequestMapping("/ContactUs")
public class ContactUsController {
	
	@Autowired
	ContactUs_Service contactUsService;
	
	// Ctrl for add Query
		@PostMapping("/postQuery")
		public ContactUs addQuery(@RequestBody ContactUs addQue) {
			return contactUsService.addQuery(addQue);
		}

		// Ctrl for get all Query
		@GetMapping("/getAllQueries")
		public List<ContactUs> getAllQueries() {
			return contactUsService.getAllQueries();
		}

		// Ctrl for get Query by Id
		@GetMapping("/sapId/{sap_Id}")
		public ContactUs searchById(@PathVariable("sap_Id") long sap_Id) {
			return contactUsService.getBySapId(sap_Id);
		}

		// Ctrl for Update status
		@PostMapping("/UpdateQuery")
		public ContactUs updatebyId(@RequestBody ContactUs cus) {
			return contactUsService.updateQuery(cus);
		}
	

}
