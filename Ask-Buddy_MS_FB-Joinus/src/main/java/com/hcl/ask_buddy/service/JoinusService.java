package com.hcl.ask_buddy.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ask_buddy.entity.Joinus;
import com.hcl.ask_buddy.exceptions.IdNotFoundException;
import com.hcl.ask_buddy.repository.JoinusRepo;

@Service
public class JoinusService {

	@Autowired
	private JoinusRepo jUsRepo;

	// Registering User for later projects
	public Joinus register(Joinus addUser) {
		return jUsRepo.save(addUser);
	}

	// Fetch All Data in JOinus Database
	public List<Joinus> getAllData() {
		return (List<Joinus>) jUsRepo.findAll();
	}

	// Fetch Data using SAP ID
	public Joinus fetchById(long sapId) {
		Optional<Joinus> js = jUsRepo.findById(sapId);
		try {
			Joinus jus = js.get();
			return jus;
		} catch (NoSuchElementException e) {
			throw new IdNotFoundException("Database does not contain any info with the SAP ID provided i.e.," + sapId);
		}
	}

	// Service for updating the status of the consulting
	public Joinus updQueStatus(long sapId, boolean newQueStatus) {
		Joinus js = jUsRepo.findById(sapId).orElse(null);
		if (js != null) {
			js.setQue_status(newQueStatus);
			return jUsRepo.save(js);
		}
		return null;
	}
}
