package com.hcl.ask_buddy.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ask_buddy.question.entity.*;

// Answer Repository
@Repository
public interface AnswerRepo extends JpaRepository<Answers, Long>{
	@Query("select answer from Answers answer where answer.question = ?1")
	public List<Answers> getAnswerByQuestionId(Question question);
}
