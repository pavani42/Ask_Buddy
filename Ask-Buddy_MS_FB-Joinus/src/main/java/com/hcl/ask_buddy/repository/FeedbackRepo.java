package com.hcl.ask_buddy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ask_buddy.entity.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

//	Optional<Feedback> findBySapId(long sapId);

	@Query("select feedback from Feedback feedback where feedback.rating = ?1")
	List<Feedback> getByRating(int rating);
}
