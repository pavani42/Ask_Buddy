package com.hcl.ask_buddy.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ask_buddy.entity.Feedback;
import com.hcl.ask_buddy.exceptions.IdNotFoundException;
import com.hcl.ask_buddy.repository.FeedbackRepo;
import com.hcl.ask_buddy.security.AuthenticatedUser;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepo fbRepo;
	
	@Autowired
	AuthenticatedUser authUser;

	// Service for adding Feedback
	public Feedback addFeed(Feedback fbdata) {
//		System.out.println(authUser.getUser());
		fbdata.setUser(authUser.getUser());
		return fbRepo.save(fbdata);
	}

	// Service for the Feedback data
	public List<Feedback> allFeeds() {
		return (List<Feedback>) fbRepo.findAll();
	}

	// Service to fetch Feedback by SAP ID
//	public Feedback fetchById(long sapId) {
//		System.out.println("at fetch by id");
//		Optional<Feedback> fb = fbRepo.findBySapId(sapId);
//		try {
//			Feedback fbs = fb.get();
//			return fbs;
//		} catch (NoSuchElementException e) {
//			throw new IdNotFoundException("Database does not contain any info with the SAP ID provided i.e.," + sapId);
//		}
//	}

	// Service for fetching data by rating 
	public List<Feedback> fetchByRatings(int rating) {
		System.out.println("at fetc by rat....");
		try {
		List<Feedback> fb = fbRepo.getByRating(rating);
			return fb;
		} catch (NoSuchElementException e) {
			throw new IdNotFoundException("Database does not contain any info with rating provided i.e.," + rating);

		}
	}

}
