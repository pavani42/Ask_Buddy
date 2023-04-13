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


// API Services for the Question
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
	AuthenticatedUser authUser;
	
	
	// Service for Fetching Question by ID
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

	// Service for searching Queston by KeyWord
	@Override
	public List<QueAndAns> searchQuestion(String word) {
		List<Question> questionList = questionRepository.getQuestionByKeyword(word);
//		if(questionList.size() == 0)
//			throw new IdNotFoundException("No Question found with the given word");
		return getQuestionAndAnswerList(questionList);
	}

	//  Service for fetcing Question and Answer by Category
	@Override
	public List<QueAndAns> searchByCategory(String Category) {
		List<Question> questionList = questionRepository.getByCategory(Category);
		if(questionList.size() == 0)
			throw new IdNotFoundException("Given category questions are not found");
		return getQuestionAndAnswerList(questionList);
	}
	
	// Service for fetching Quesion and Answer by Sub-Category
	@Override
	public List<QueAndAns> searchBySubCategory(String subCat) {
		List<Question> questionList = questionRepository.getBySubCategory(subCat);
		if(questionList.size() == 0)
			throw new IdNotFoundException("Given sub category questions are not found");
		return getQuestionAndAnswerList(questionList);
	}
	
	// Service for Fetchin Q&A 
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

	// Service for Adding Question
	// This module saves the question into the question database
	@Override
	public Question postQuestion(String cat, String subCat, String question, String questionDescription) {
		
		question = question.trim();
		if(questionRepository.getQuestionByQuestion(question) == null)
		{
			Question question1 = new Question();
			question1.setDate(LocalDateTime.now());
			question1.setUser(userRepo.findById(authUser.getUser().getSap_Id()).get());
			question1.setCat(catRepo.getCategory(cat));
			question1.setSubCat(subCatRepo.getCategory(subCat));
			question1.setQuestion(question);
			question1.setQuesDescription(questionDescription);
			questionRepository.save(question1);
			return question1;
		}
		else 
			throw new IdNotFoundException("Given question is already exists");
	}

	// Service for Updating the Question
	@Override
	public boolean updateQuestion(long id, String question) {
		question = question.trim();
		if(questionRepository.existsById(id) != true)
			throw new IdNotFoundException("Given id is not found");
		int n = questionRepository.updateQuestion(id, question, authUser.getUser());
		if(n == 0)
			return false;
		return true;

	}

	// Service for Deleting the Question with ID
	@Override
	public String deleteQuestion(long id) {
		if(questionRepository.existsById(id) != true)
			throw new IdNotFoundException("Given id is not found");;
        if(questionRepository.findById(id).get().getUser().getSap_Id() == authUser.getUser().getSap_Id())
        {
		questionRepository.deleteById(id);
		return "SuccessFully Deleted"; 
        }
        else
        	return "Not a valid User";

	}

	// Service for Fetching Latest Quesions
	@Override
	public List<QueAndAns> getLatestQuestion() {
		List<Question> questionList = questionRepository.getQuestionByDate();
		return getQuestionAndAnswerList(questionList);
		}

	// Service for Fetching User Posted Questions
	@Override
	public List<QueAndAns> getByUser() {
		List<Question> questionList = questionRepository.getQuestionByUser(authUser.getUser());
		return getQuestionAndAnswerList(questionList);
	}

	@Override
	public List<Category> getCategoryList() {
		
		return catRepo.findAll();
		}

	@Override
	public List<Sub_Category> getSubCategoryListByCategory(String cat) {
		return subCatRepo.subCategoryList(cat);
	}

	@Override
	public List<QueAndAns> getDataByCategory(String cat, String subcat) {
		
		List<Question> questionList = questionRepository.getQuestionList(cat, subcat);
		return getQuestionAndAnswerList(questionList); 
	}

}
