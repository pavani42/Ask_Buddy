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

import com.hcl.ask_buddy.dto.QueAndAns;
import com.hcl.ask_buddy.dto.Question;
import com.hcl.ask_buddy.exception.IdNotFoundException;
import com.hcl.ask_buddy.security.AuthenticatedUser;



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
		return generateUrl.getBaseUrl("Question_MicroService");
	}
	
	public String addQuestion(String category, String sub_Category, String question)
	{
//		if(session.getAttribute("id") == null)
//		{
//			return "Please Login";
//		}
		if(restTemplate.exchange(getUrl() + "/postQuestion/" + authenticatedUser.getUser().getSap_Id() + "?category=" + category + "&sub_Category=" + sub_Category + "&question=" + question ,HttpMethod.GET, new HttpEntity<>(setToken()), Question.class) != null)
		{
			return "Question Posted Successfully";
		}
		else
		{
			return "Error in posting question";
		}
	}
	
	public Question getQuestionByID(long id)
	{
//		return restTemplate.exchange(getUrl() + "/getQuestion/" + id, HttpMethod.GET, new HttpEntity<>(setToken()), Question.class).getBody();
		return restTemplate.exchange(getUrl() + "/getQuestion/" + id, HttpMethod.GET, new HttpEntity<>(setToken()), Question.class).getBody();
	}
	
	public List<QueAndAns> getByCategory(String category)
	{
		QueAndAns[] queAndAns =  restTemplate.exchange(getUrl() + "/SearchQuestionByCategory/" + category, HttpMethod.GET, new HttpEntity<>(setToken()),QueAndAns[].class).getBody();
		return Arrays.asList(queAndAns); 
	}
	
	public List<QueAndAns> getBySubCategory(String sub_category)
	{
		QueAndAns[] queAndAns =  restTemplate.exchange(getUrl() + "/SearchQuestionBySubCategory/" + sub_category,HttpMethod.GET, new HttpEntity<>(setToken()), QueAndAns[].class).getBody();
		return Arrays.asList(queAndAns); 
	}
	
	@GetMapping("/GetUserQuestions")
	public List<QueAndAns> getUserQuestions()
	{
		QueAndAns[] queAndAns = restTemplate.exchange(getUrl()+ "/getQuestionByUser/" + authenticatedUser.getUser().getSap_Id(),HttpMethod.GET, new HttpEntity<>(setToken()), QueAndAns[].class).getBody();
		return Arrays.asList(queAndAns);
	}
	
	@GetMapping("/SearchByKeyword")
	public List<ResponseEntity<QueAndAns[]>> getByKeyword(String keyword)
	{
		ResponseEntity<QueAndAns[]> queAndAns =  restTemplate.exchange(getUrl() + "/SearchQuestionByKeyword/" + keyword,HttpMethod.GET, new HttpEntity<>(setToken()), QueAndAns[].class);
		return Arrays.asList(queAndAns); 
	}
	
	@GetMapping("/DeleteQuestion")
	public void deleteQuestion(long questionId)
	{
		restTemplate.exchange(getUrl()+"/DeleteQuestion/" + questionId, HttpMethod.DELETE, new HttpEntity<>(setToken()), boolean.class).getBody();
	}
	
	@PostMapping("/updateQuestion")
	public boolean updateQuestion(long quesId, String question)
	{
		return restTemplate.exchange(getUrl() + "/UpdateQuestion/" + quesId + "?question=" + question,HttpMethod.POST, new HttpEntity<>(setToken()), boolean.class).getBody();
	}
	
	@GetMapping("/getLatestQuestion")
	public List<QueAndAns> getLatestQuestions()
	{
		QueAndAns[] queAndAnsList = restTemplate.exchange(getUrl() + "/GetLatestQuestions" , HttpMethod.GET, new HttpEntity<>(setToken()), QueAndAns[].class).getBody();
		return Arrays.asList(queAndAnsList);
	}
	
	public HttpHeaders setToken() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + authenticatedUser.getToken());
		headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}


}
