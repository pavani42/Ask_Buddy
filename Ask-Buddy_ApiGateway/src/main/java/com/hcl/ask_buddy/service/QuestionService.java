package com.hcl.ask_buddy.service;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.hcl.ask_buddy.dto.Answers;
import com.hcl.ask_buddy.dto.QueAndAns;
import com.hcl.ask_buddy.dto.Question;
import com.hcl.ask_buddy.exception.IdNotFoundException;
import com.hcl.ask_buddy.security.AuthenticatedUser;

// Question Services - Business Logics
@Service
public class QuestionService {
	
	@Autowired
	private GenarateUrl generateUrl;

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AuthenticatedUser authenticatedUser;

	public String getUrl()
	{
		return generateUrl.getBaseUrl("Question-MicroService");
	}
	
	// Service for Adding Questions 
	public String addQuestion(String category, String sub_Category, String question, String questionDescription)
	{
//		Question quest = restTemplate.postForObject(getUrl() + "/postQuestion/" + authenticatedUser.getUser().getSap_Id() + "?category=" + category + "&sub_Category=" + sub_Category + "&question=" + question + "&questionDescription=" + questionDescription ,HttpMethod.POST, Question.class);
		Question quest = restTemplate.exchange(getUrl() + "/api/questions/postQuestion?category=" + category + "&sub_Category=" + sub_Category + "&question=" + question + "&questionDescription=" + questionDescription, HttpMethod.POST, new HttpEntity<>(setToken()), Question.class).getBody();
		System.out.println(quest);
		if(quest.getQuestion() != null)
			return "Question Posted Successfully";
		else
			return "Question Already Exists";
	}
	
	// Service for fetch Question by ID
	public Question getQuestionByID(long id)
	{
		return restTemplate.exchange(getUrl() + "/api/questions/question/" + id, HttpMethod.GET, new HttpEntity<>(setToken()), Question.class).getBody();
	}
	
	// Service for fetching Question & Answers by Category
	public List<QueAndAns> getByCategory(String category)
	{
		QueAndAns[] queAndAns =  restTemplate.exchange(getUrl() + "/api/questions/searchQuestionByCategory/" + category, HttpMethod.GET, new HttpEntity<>(setToken()),QueAndAns[].class).getBody();
		return Arrays.asList(queAndAns); 
	}
	
	// Service for fetching Question & Answers by Sub-Category
	public List<QueAndAns> getBySubCategory(String sub_category)
	{
		QueAndAns[] queAndAns =  restTemplate.exchange(getUrl() + "/api/questions/searchQuestionBySubCategory/" + sub_category,HttpMethod.GET, new HttpEntity<>(setToken()), QueAndAns[].class).getBody();
		return Arrays.asList(queAndAns); 
	}
	
	// Service for feting User posted Questions
	@GetMapping("/GetUserQuestions")
	public List<QueAndAns> getUserQuestions()
	{
		QueAndAns[] queAndAns = restTemplate.exchange(getUrl()+ "/api/questions/questionByUser",HttpMethod.GET, new HttpEntity<>(setToken()), QueAndAns[].class).getBody();
		return Arrays.asList(queAndAns);
	}
	
	// Service for fetch Question with Keyword
	@GetMapping("/SearchByKeyword")
	public List<QueAndAns> getByKeyword(String keyword)
	{
		ResponseEntity<QueAndAns[]> queAndAns =  restTemplate.exchange(getUrl() + "/api/questions/searchQuestionByKeyword/" + keyword,HttpMethod.GET, new HttpEntity<>(setToken()), QueAndAns[].class);
		return Arrays.asList(queAndAns.getBody()); 
	}
	
	// Service for Deleting Question with ID
	@GetMapping("/DeleteQuestion")
	public String deleteQuestion(long questionId)
	{
		return restTemplate.exchange(getUrl()+"/api/questions/question/" + questionId, HttpMethod.DELETE, new HttpEntity<>(setToken()), String.class).getBody();
	}
	
	// Service for Updating Question with ID
	@PostMapping("/updateQuestion")
	public boolean updateQuestion(long quesId, String question)
	{
		return restTemplate.exchange(getUrl() + "/api/questions/updateQuestion/" + quesId + "?question=" + question,HttpMethod.POST, new HttpEntity<>(setToken()), boolean.class).getBody();
	}
	
	// Service for fetcing Latest Questions
	@GetMapping("/getLatestQuestion")
	public List<QueAndAns> getLatestQuestions()
	{
		QueAndAns[] queAndAnsList = restTemplate.getForObject(getUrl() + "/api/questions/latestQuestions" , QueAndAns[].class);
		return Arrays.asList(queAndAnsList);
	}

	// Service for Token generation
	public HttpHeaders setToken() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + authenticatedUser.getToken());
		headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		return headers;
	}
	


}
