package com.hcl.ask_buddy.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import com.hcl.ask_buddy.dto.Answers;
import com.hcl.ask_buddy.exception.IdNotFoundException;
import com.hcl.ask_buddy.exception.RestTemplateErrorHandler;
import com.hcl.ask_buddy.security.AuthenticatedUser;

// Answer Servive  - Business Logics
@Service
public class AnswerService{

	@Autowired
	private GenarateUrl generateUrl;

	@Autowired
	private AuthenticatedUser authenticatedUser;

	private RestTemplate restTemplate;



	@Autowired
	public AnswerService(RestTemplateBuilder restTemplateBuilder)
	{
		this.restTemplate = restTemplateBuilder
				.errorHandler(new RestTemplateErrorHandler())
				.build();
	}

	public AnswerService() {
		// TODO Auto-generated constructor stub
	}

	public String getUrl()
	{
		return generateUrl.getBaseUrl("Answer-MicroService");
	}

	// Service for adding Answer
	public Answers postAnswers(String answer, String question)
	{
		return restTemplate.exchange(getUrl() + "/api/answers/postAnswer?answer=" + answer + "&question=" + question, HttpMethod.POST, new HttpEntity<>(setToken()), Answers.class).getBody();
	}

	// Service for fetch Ans by Question
	public List<Answers> getAnswersByQuestion(String question) 
	{
		System.out.println(question);
		try
		{
			Answers[] queAndAns = restTemplate.exchange(getUrl() + "/api/answers/answersByQuestion?question=" + question,HttpMethod.GET, new HttpEntity<>(setToken()), Answers[].class).getBody();
			return Arrays.asList(queAndAns);
		}
		catch(Exception e)
		{
			throw new IdNotFoundException(e.toString());
		}
	}

	// Service for fetch ANswer by ID
	public Answers getAnswerById(long id)
	{
		return restTemplate.exchange(getUrl() + "/api/answers/answerById/" + id,HttpMethod.GET, new HttpEntity<>(setToken()), Answers.class).getBody();
	}

	// Service for update Answer by ID
	public String updateAnswer(long id, String answer)
	{
		return restTemplate.exchange(getUrl() + "/api/answers/updateAnswer?id=" + id + "&answer=" + answer,HttpMethod.POST, new HttpEntity<>(setToken()), String.class).getBody();
	}

	// Service for Delete Answer by ID
	public String deleteAnswer(long id)
	{
		return restTemplate.exchange(getUrl() + "/api/answers/answer/" + id, HttpMethod.DELETE, new HttpEntity<>(setToken()), String.class).getBody();
	}

	// Service for Token
	public HttpHeaders setToken() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + authenticatedUser.getToken());
		headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		return headers;
	}

	public List<Answers> getUserAnswers() {
		Answers[] answerList = restTemplate.exchange(getUrl() + "/api/answers/userAnswers", HttpMethod.GET, new HttpEntity<>(setToken()), Answers[].class).getBody();
		return Arrays.asList(answerList);
	}



}
