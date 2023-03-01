package com.hcl.ask_buddy.question.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.ask_buddy.question.entity.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// Question Repository
@Repository
public interface QuestionsRepo extends JpaRepository<Question, Long>{
	@Query("select quest from Question quest where quest.cat.cat_name = ?1")
	public List<Question> getByCategory(String cat);
	
	@Query("select quest from Question quest where quest.subCat.subcat_name = ?1")
	public List<Question> getBySubCategory(String cat);
	
	@Query("select quest from Question quest where quest.quesDescription LIKE CONCAT('%',:keyword,'%') or quest.question LIKE CONCAT('%',:keyword,'%')")
	public List<Question> getQuestionByKeyword(@Param("keyword") String keyword);
	
	@Modifying
	@Transactional
	@Query("update Question ques set ques.question = :question where ques.id = :id and ques.user = :user")
	public int updateQuestion(@Param("id") long id, @Param("question")String question, @Param("user")User user);
	
	@Query("select ques from Question ques order by ques.date desc")
	public List<Question> getQuestionByDate();
	
	@Query("select ques from Question ques where ques.question = ?1")
	public Question getQuestionByQuestion(String quest);
	
	@Query("select ques from Question ques where ques.user = ?1")
	public List<Question> getQuestionByUser(User user);
	
	@Modifying
	@Query("delete from Question ques where ques.id = ?1 and ques.user = ?2")
	public int deleteQuestion(long id, User user);
}
