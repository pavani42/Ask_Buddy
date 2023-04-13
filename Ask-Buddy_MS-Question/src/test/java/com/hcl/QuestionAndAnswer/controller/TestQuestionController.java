package com.hcl.QuestionAndAnswer.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.test.web.servlet.ResultActions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import com.hcl.ask_buddy.question.entity.*;
import com.hcl.ask_buddy.question.exception.IdNotFoundException;
import com.hcl.ask_buddy.question.security.AuthenticatedUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.hcl.ask_buddy.question.controller.QuestionController;
import com.hcl.ask_buddy.question.dto.QueAndAns;
import com.hcl.ask_buddy.question.service.QuestionImpl;

@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class TestQuestionController {

	private MockMvc mockMvc;

	@Mock
	private QuestionImpl questionService;

	@InjectMocks
	private QuestionController questionController;
	
	@Mock
	AuthenticatedUser authuser;

	User user;
	
	Question question;

	Category category;

	Sub_Category subCat;

	QueAndAns queAndAns;
	
	Gson json;


	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(questionController).build();
		user = User.builder().sap_Id(52112593).mail("test@gmail.com").username("test").password("$2a$10$x3/ufTsGe5GWleD334csK.9rY1xiIGqP4lEV4VlB6WXQR9ff6bxqW").build();
		category = Category.builder().id(1).cat_name("Technology").build();
		subCat = Sub_Category.builder().id(1).category(category).subcat_name("Java").build();
		question = Question.builder().user(user).id(1).cat(category).subCat(subCat).question("What is abstraction?").quesDescription("What is abstraction")
				.build();
		queAndAns = QueAndAns.builder().question(question).AnswerList(null).build();
		json = new Gson();
	}
	
	@Test
	public void testGetQuestion() throws Exception
	{
		Mockito.when(questionService.getQuestion(1)).thenReturn(question);
		MockHttpServletResponse response = mockMvc.perform(get("/question/" + 1).accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertFalse(response.getContentAsString().isEmpty());
		 
		
	}
	
	@Test
	public void testSearchQuestion() throws Exception
	{
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question); 
		List<QueAndAns> queAndAns = new ArrayList<>();
		queAndAns.add(QueAndAns.builder().question(question).AnswerList(new ArrayList<Answers>()).build());
		Mockito.when(questionService.searchQuestion("is")).thenReturn(queAndAns);
		MockHttpServletResponse response = mockMvc.perform(get("/searchQuestionByKeyword/is").accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertFalse(response.getContentAsString().isEmpty());
		
	}
	
	@Test
	public void testSearchByCategory() throws Exception
	{
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question);
		List<QueAndAns> queAndAns = new ArrayList<>();
		queAndAns.add(QueAndAns.builder().question(question).AnswerList(new ArrayList<Answers>()).build());
		Mockito.when(questionService.searchByCategory("Technology")).thenReturn(queAndAns);
		MockHttpServletResponse response = mockMvc.perform(get("/searchQuestionByCategory/Technology").accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertFalse(response.getContentAsString().isEmpty());	
	}
	
	@Test
	public void testSearchBySubCategory() throws Exception
	{
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question);
		List<QueAndAns> queAndAns = new ArrayList<>();
		queAndAns.add(QueAndAns.builder().question(question).AnswerList(new ArrayList<Answers>()).build());
		Mockito.when(questionService.searchBySubCategory("Java")).thenReturn(queAndAns);
		MockHttpServletResponse response = mockMvc.perform(get("/searchQuestionBySubCategory/Java").accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertFalse(response.getContentAsString().isEmpty());	

	}
	
	@Test
	public void testPostQuestion() throws Exception
	{
		Mockito.when(authuser.getUser()).thenReturn(user);
		Mockito.when(questionService.postQuestion(question.getCat().getCat_name(), 
				question.getSubCat().getSubcat_name(), question.getQuestion(), question.getQuesDescription())).thenReturn(question);
		MockHttpServletResponse response = mockMvc.perform(post("/postQuestion" + "?category=" + question.getCat().getCat_name()
				+ "&sub_Category=" + question.getSubCat().getSubcat_name() + "&question=" + question.getQuestion() + "&questionDescription=" + question.getQuesDescription())
				.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertFalse(response.getContentAsString().isEmpty());	
		
	}
	
	
	@Test
	public void testUpdateQuestion() throws Exception
	{
		Mockito.when(questionService.updateQuestion(1, "What is abstraction?")).thenReturn(true);
		MockHttpServletResponse response = mockMvc.perform(post("/updateQuestion/" + 1 + "?question=What is abstraction?")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertEquals(response.getContentAsString().length(), 4);	
	}
	
	
	@Test
	public void testDeleteQuestion() throws Exception
	{
		Mockito.when(questionService.deleteQuestion((long) 1)).thenReturn("SuccessFully Deleted");
		MockHttpServletResponse response = mockMvc.perform(delete("/question/" + 1)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertEquals(response.getContentAsString().compareTo("SuccessFully Deleted"), 0);
	}
	

	@Test
	public void testGetLatestQuestion() throws Exception
	{
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question);
		List<QueAndAns> queAndAns = new ArrayList<>();
		queAndAns.add(QueAndAns.builder().question(question).AnswerList(new ArrayList<Answers>()).build());
		MockHttpServletResponse response = mockMvc.perform(get("/latestQuestions")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertFalse(response.getContentAsString().isEmpty());	
	}
	
	@Test
	public void testGetByUser() throws Exception
	{
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question);
		List<QueAndAns> queAndAns = new ArrayList<>();
		queAndAns.add(QueAndAns.builder().question(question).AnswerList(new ArrayList<Answers>()).build());
		Mockito.when(questionService.getByUser()).thenReturn(queAndAns);
		Mockito.when(authuser.getUser()).thenReturn(user);
		MockHttpServletResponse response = mockMvc.perform(get("/questionByUser")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertFalse(response.getContentAsString().isEmpty());	
	}
	
	@Test
	public void testGetCategoryList() throws Exception
	{
		List<Category> categoryList = new ArrayList<>();
		categoryList.add(category);
		Mockito.when(questionService.getCategoryList()).thenReturn(categoryList);
		MockHttpServletResponse response = (MockHttpServletResponse) mockMvc.perform(get("/getCategoryList")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertFalse(response.getContentAsString().isEmpty());	
						
	}
	
	@Test
	public void testGetSubCategoryList() throws Exception
	{
		List<Sub_Category> categoryList = new ArrayList<>();
		categoryList.add(subCat);
		Mockito.when(questionService.getSubCategoryListByCategory(category.getCat_name())).thenReturn(categoryList);
		MockHttpServletResponse response = (MockHttpServletResponse) mockMvc.perform(get("/getSubCategoryList/" + category.getCat_name())
				.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertFalse(response.getContentAsString().isEmpty());	
						
	}
	
	@Test
	public void testGetQuestionByList() throws Exception
	{
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question);
		List<QueAndAns> queAndAns = new ArrayList<>();
		queAndAns.add(QueAndAns.builder().question(question).AnswerList(new ArrayList<Answers>()).build());
		Mockito.when(questionService.getDataByCategory(category.getCat_name(), subCat.getSubcat_name())).thenReturn(queAndAns);
		MockHttpServletResponse response = (MockHttpServletResponse) mockMvc.perform(get("/getQuestionsByCategory?cat=" + category.getCat_name() + "&subCat=" + subCat.getSubcat_name())
				.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertFalse(response.getContentAsString().isEmpty());	
						
	}
	


}

