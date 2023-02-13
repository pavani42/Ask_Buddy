package com.hcl.ask_buddy.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ask_buddy.entity.ContactUs;
import com.hcl.ask_buddy.exceptions.IdNotFoundException;
import com.hcl.ask_buddy.repository.ContactUsRepo;

@Service
public class ContactUsService {

	@Autowired
	private ContactUsRepo conUsRepo;

	// Add Query
	public ContactUs addQuery(ContactUs addQ) {
		return conUsRepo.save(addQ);
	}

	// Search Query by SAP ID
	public ContactUs searchById(long sap_Id) {
		Optional<ContactUs> op = conUsRepo.findById(sap_Id);
		try {
			ContactUs cus = op.get();
			return cus;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new IdNotFoundException(
					"Database does not contain any info or Queries with the given SAP ID :" + sap_Id);
		}
	}

	// Get All Query
	public List<ContactUs> getAllQueries() {
		return (List<ContactUs>) conUsRepo.findAll();
	}

	// Update Status by SAP ID
	public ContactUs updatebyId(ContactUs upd) {
		ContactUs existingId = searchById(upd.getSap_Id());
		if (existingId != null) {
			conUsRepo.save(upd);
			return upd;
		} else {
			System.out.println("Database does not contain the SAP ID:" + upd.getSap_Id());
			return null;
		}

	}
}
