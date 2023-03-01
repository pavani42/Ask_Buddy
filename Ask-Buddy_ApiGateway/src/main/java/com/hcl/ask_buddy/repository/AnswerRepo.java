package com.hcl.ask_buddy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.ask_buddy.entity.*;

// Answer Repository

@Repository
public interface AnswerRepo extends JpaRepository<Answers, Long>{
	@Query("select answer from Answers answer where answer.question.quesDescription = ?1")
	public List<Answers> getAnswerByQuestion(String question);
	
	@Query("select answer from Answers answer where answer.question = ?1")
	public List<Answers> getAnswerByQuestionId(Question question);
	
	@Modifying
	@Transactional
	@Query("update Answers answer set answer.description = :answer where answer.id = :id")
	public int updateAnswer(@Param("id")long id, @Param("answer")String answer);
}
