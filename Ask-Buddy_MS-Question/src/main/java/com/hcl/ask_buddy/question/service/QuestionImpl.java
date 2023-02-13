package com.hcl.ask_buddy.question.service;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.hcl.ask_buddy.question.dto.QueAndAns;
import com.hcl.ask_buddy.question.entity.*;
import com.hcl.ask_buddy.question.exception.IdNotFoundException;
import com.hcl.ask_buddy.question.repository.*;
import com.hcl.ask_buddy.question.security.AuthenticatedUser;

@Service
public class QuestionImpl implements QuestionService{

	@Autowired
	QuestionsRepo questionRepository;

	@Autowired
	CategoryRepo catRepo;

	@Autowired
	SubCategoryRepo subCatRepo;

	@Autowired
	AnswerRepo answerRepo;

	@Autowired 
	UserRepo userRepo;
	
	@Autowired
	AuthenticatedUser authenticatedUser;
	
	@Override
	public Question getQuestion(long id) {
		try
		{
			Question question = questionRepository.findById(id).get();
			return question;
		}
		catch(NoSuchElementException exception)
		{
			throw new IdNotFoundException("Please Enter the valid Question Id");
		}
	}

	@Override
	public List<QueAndAns> searchQuestion(String word) {
		List<Question> questionList = questionRepository.getQuestionByKeyword(word);
		if(questionList.size() == 0)
			throw new IdNotFoundException("No Question found with the given word");
		return getQuestionAndAnswerList(questionList);
	}

	@Override
	public List<QueAndAns> searchByCategory(String Category) {
		List<Question> questionList = questionRepository.getByCategory(Category);
		if(questionList.size() == 0)
			throw new IdNotFoundException("Given category questions are not found");
		return getQuestionAndAnswerList(questionList);
	}
	
	@Override
	public List<QueAndAns> searchBySubCategory(String subCat) {
		List<Question> questionList = questionRepository.getBySubCategory(subCat);
		if(questionList.size() == 0)
			throw new IdNotFoundException("Given sub category questions are not found");
		return getQuestionAndAnswerList(questionList);
	}
	
	public List<QueAndAns> getQuestionAndAnswerList(List<Question> questionList)
	{
		List<QueAndAns> qalist = new ArrayList<QueAndAns>();
		for(Question ques : questionList)
		{
			QueAndAns qa = new QueAndAns();
			qa.setQuestion(ques);
			qa.setAnswerList(answerRepo.getAnswerByQuestionId(ques));
			qalist.add(qa);
		}
		return qalist;
	}

	// This module saves the question into the question database
	@Override
	public Question postQuestion(long id, String cat, String subCat, String question) {
//		User user = userRepo.findById((long) id).get();
		question = question.trim();
		if(questionRepository.getQuestionByQuestion(question) == null)
		{
			Question question1 = new Question();
			question1.setDate(LocalDateTime.now());
			question1.setUser(authenticatedUser.getUser());
			question1.setCat(catRepo.getCategory(cat));
			question1.setSubCat(subCatRepo.getCategory(subCat));
			question1.setQuesDescription(question);
			questionRepository.save(question1);
			return question1;
		}
		else 
			throw new IdNotFoundException("Given question is already exists");
	}

	@Override
	public boolean updateQuestion(long id, String question) {
		question = question.trim();
		if(questionRepository.existsById(id) != true)
			return false;
		try
		{
		    questionRepository.updateQuestion(authenticatedUser.getUser().getSap_Id(), question);
		    return true;
		}
		catch(NoSuchElementException exception)
		{
			throw new IdNotFoundException("Given id is not found");
		}
	}

	@Override
	public boolean deleteQuestion(long id) {
		try
		{
		    questionRepository.deleteById(id);
		    return true;
		}
		catch(NoSuchElementException exception)
		{
			throw new IdNotFoundException("Given id is not found");
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new IdNotFoundException("No Element found with the given id");
		}
	}

	@Override
	public List<QueAndAns> getLatestQuestion() {
		List<Question> questionList = questionRepository.getQuestionByDate();
		return getQuestionAndAnswerList(questionList);
		}

	@Override
	public List<QueAndAns> getByUser(long userId) {
		List<Question> questionList = questionRepository.getQuestionByUser(userRepo.findById(userId).get());
		return getQuestionAndAnswerList(questionList);
	}



}
