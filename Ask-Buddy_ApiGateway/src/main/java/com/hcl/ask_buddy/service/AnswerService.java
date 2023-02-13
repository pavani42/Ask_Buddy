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
import com.hcl.ask_buddy.exception.RestTemplateErrorHandler;
import com.hcl.ask_buddy.security.AuthenticatedUser;

@Service
public class AnswerService {
	
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

	public String getUrl()
	{
		return generateUrl.getBaseUrl("Answer_MicroService");
	}
	
	public Answers postAnswers(String answer, String question)
	{
		return restTemplate.exchange(getUrl() + "/PostAnswer/" + authenticatedUser.getUser().getSap_Id() + "?answer=" + answer + "&question=" + question, HttpMethod.GET, new HttpEntity<>(setToken()), Answers.class).getBody();
	}
	
	@GetMapping("/getAnswerByQuestion")
	public List<Answers> getAnswersByQuestion(String question) 
	{
		try
		{
			System.out.println(question);
			Answers[] queAndAns = restTemplate.exchange(getUrl() + "/GetAnswersByQuestion?question=" + question,HttpMethod.GET, new HttpEntity<>(setToken()), Answers[].class).getBody();
			return Arrays.asList(queAndAns);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Answers getAnswerById(long id)
	{
		return restTemplate.exchange(getUrl() + "/GetAnswerById/" + id,HttpMethod.GET, new HttpEntity<>(setToken()), Answers.class).getBody();
	}
	
	public String updateAnswer(long id, String answer)
	{
		return restTemplate.exchange(getUrl() + "/UpdateAnswer?id=" + id + "&answer=" + answer,HttpMethod.GET, new HttpEntity<>(setToken()), String.class).getBody();
	}
	
	public String deleteAnswer(long id)
	{
		return restTemplate.exchange(getUrl() + "/DeleteAnswer/" + id,HttpMethod.GET, new HttpEntity<>(setToken()), String.class).getBody();
	}
	
	public HttpHeaders setToken() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + authenticatedUser.getToken());
		headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}
	
}
