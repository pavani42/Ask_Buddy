package com.hcl.QuestionAndAnswer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hcl.ask_buddy.question.dto.QueAndAns;
import com.hcl.ask_buddy.question.entity.*;
import com.hcl.ask_buddy.question.exception.IdNotFoundException;
import com.hcl.ask_buddy.question.repository.*;
import com.hcl.ask_buddy.question.security.AuthenticatedUser;
import com.hcl.ask_buddy.question.service.QuestionImpl;

@ExtendWith(MockitoExtension.class)
public class TestQuestionService {
	
	@InjectMocks
	QuestionImpl questionService;
	
	@Mock
	AnswerRepo answerRepo;
	
	@Mock
	QuestionsRepo questionRepo;
	
	@Mock
	CategoryRepo categoryRepo;
	
	@Mock
	SubCategoryRepo subCatRepo;
	
	@Mock
	UserRepo userRepo;
	
	@Mock
	AuthenticatedUser authUser;
	
	Question question;
	
	User user;
	
	Category category;
	
	Sub_Category subCat;
	
	QueAndAns queAndAns;
	
	@BeforeEach
	public void setUp()
	{
		user = User.builder().sap_Id(52112593).mail("test@gmail.com").username("test").password("$2a$10$x3/ufTsGe5GWleD334csK.9rY1xiIGqP4lEV4VlB6WXQR9ff6bxqW").build();
		category = Category.builder().id(1).cat_name("Technology").build();
		subCat = Sub_Category.builder().id(1).category(category).subcat_name("Java").build();
		question = Question.builder().user(user).id(1).cat(category).subCat(subCat).question("What is abstraction?").quesDescription("What is abstraction")
				.build();
		authUser.setUser(user);
		queAndAns = QueAndAns.builder().question(question).AnswerList(null).build();
	}
	
	@Test
	public void testGetQuestion()
	{
		Mockito.when(questionRepo.findById((long) 1)).thenReturn(Optional.of(question));
		assertEquals(questionService.getQuestion(1), question);
	}
	
	@Test
	public void testGetQuestion_throws_Exception()
	{
//		Mockito.when(questionRepo.findById((long) 1)).thenReturn(Optional.of(question));
//		assertEquals(questionService.getQuestion(1), question);
		assertThrows(IdNotFoundException.class, () -> {
			questionService.getQuestion((long) 2);
		});
	}
	
	@Test
	public void testSearchQuestionByCat_throws_Exception()
	{
		assertThrows(IdNotFoundException.class, () -> {
			questionService.searchByCategory("tech");
		});
	}
	
	@Test
	public void testSearchQuestionBySubCat_throws_Exception()
	{
		assertThrows(IdNotFoundException.class, () -> {
			questionService.searchBySubCategory("ja");
		});
	}
	 
	@Test
	public void testSearchQuestion()
	{
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question);
		Mockito.when(questionRepo.getQuestionByKeyword("is")).thenReturn(questionList);
		Mockito.when(answerRepo.getAnswerByQuestionId(question)).thenReturn(null);
		assertEquals(questionService.searchQuestion("is").size(), 1);
	}
	
//	@Test
//	public void testSearchQuestion_throws_Exception()
//	{
//		List<Question> questionList = new ArrayList<Question>();
//		Mockito.when(questionRepo.getQuestionByKeyword("is")).thenReturn(questionList);
//		assertThrows(IdNotFoundException.class, () -> {
//					questionService.searchQuestion("is");
//		});
//	}
	
	@Test
	public void testSearchByCategory()
	{
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question);
		Mockito.when(questionRepo.getByCategory("Technology")).thenReturn(questionList);
		Mockito.when(answerRepo.getAnswerByQuestionId(question)).thenReturn(null);
		assertEquals(questionService.searchByCategory("Technology").size(), 1);
	}
	
	@Test
	public void testSearchBySubCategory()
	{
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question);
		Mockito.when(questionRepo.getBySubCategory("Java")).thenReturn(questionList);
		Mockito.when(answerRepo.getAnswerByQuestionId(question)).thenReturn(null);
		assertEquals(questionService.searchBySubCategory("Java").size(), 1);

	}
	
	@Test
	public void testPostQuestion()
	{
		Mockito.when(questionRepo.save(Mockito.any(Question.class))).thenReturn(question);
		Mockito.when(questionRepo.getQuestionByQuestion(question.getQuestion())).thenReturn(null);
		Mockito.when(userRepo.findById((long) 52112593)).thenReturn(Optional.of(user));
		Mockito.when(authUser.getUser()).thenReturn(user);
		assertNotNull(questionService.postQuestion(question.getCat().getCat_name(), 
				question.getSubCat().getSubcat_name(), question.getQuestion(), question.getQuesDescription()));
	}
	
	@Test
	public void testPostQuestion_throws_Exception()
	{
		Mockito.when(questionRepo.getQuestionByQuestion(question.getQuestion())).thenReturn(question);
		assertThrows(IdNotFoundException.class, () -> {
			questionService.postQuestion(question.getCat().getCat_name(), 
					question.getSubCat().getSubcat_name(), question.getQuestion(), question.getQuesDescription());
		});
	}
	
	@Test
	public void testUpdateQuestion()
	{
		Mockito.when(questionRepo.existsById((long) 1)).thenReturn(true);
		Mockito.when(questionRepo.updateQuestion(1, "What is abstraction?", null)).thenReturn(1);
		assertTrue(questionService.updateQuestion(1, "What is abstraction?"));
	}
	
	@Test
	public void test2UpdateQuestion()
	{
		Mockito.when(questionRepo.existsById((long) 1)).thenReturn(true);
		Mockito.when(questionRepo.updateQuestion(1, "What is abstraction?", null)).thenReturn(0);
		assertFalse(questionService.updateQuestion(1, "What is abstraction?"));
	}
	
	@Test
	public void testUpdateQuestion_throws_Exception()
	{
		Mockito.when(questionRepo.existsById((long) 1)).thenReturn(false);
		assertThrows(IdNotFoundException.class, () -> {
			questionService.updateQuestion(1, "What is abstraction?");
		});
	}
	
	@Test
	public void testDeleteQuestion()
	{
		Mockito.when(questionRepo.existsById((long) 1)).thenReturn(true);
//		Mockito.when(userRepo.findById(52112593).get()).thenReturn(user);
		Mockito.when(questionRepo.findById((long) 1)).thenReturn(Optional.of(question));
		Mockito.when(authUser.getUser()).thenReturn(user);
		assertEquals(questionService.deleteQuestion(1), "SuccessFully Deleted"); 
	}
	
	@Test
	public void testDeleteQuestion_throws_Exception()
	{
		Mockito.when(questionRepo.existsById((long) 1)).thenReturn(false);
		assertThrows(IdNotFoundException.class, () -> {
			questionService.deleteQuestion((long) 1);
		});
	}
	
	@Test
	public void testGetLatestQuestion()
	{
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question);
		Mockito.when(questionRepo.getQuestionByDate()).thenReturn(questionList);
		assertEquals(questionService.getLatestQuestion().size(), 1);
	}
	
	@Test
	public void testGetByUser()
	{
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question);
//		Mockito.when(userRepo.findById(52112593)).thenReturn(Optional.of(user));
		Mockito.when(authUser.getUser()).thenReturn(user);
		Mockito.when(questionRepo.getQuestionByUser(user)).thenReturn(questionList);
		assertEquals(questionService.getByUser().size(), 1);
	}
	
	@Test
	public void testGetCategoryList() 
	{
		List<Category> categoryList = new ArrayList<>();
		categoryList.add(category);
		Mockito.when(categoryRepo.findAll()).thenReturn(categoryList);
		assertEquals(questionService.getCategoryList().size(), 1);
	}

	@Test
	public void testGetSubCategoryList() throws Exception
	{
		List<Sub_Category> categoryList = new ArrayList<>();
		categoryList.add(subCat);
		Mockito.when(subCatRepo.subCategoryList(category.getCat_name())).thenReturn(categoryList);
		assertEquals(questionService.getSubCategoryListByCategory(category.getCat_name()).size(), 1);
	}
	
	@Test
	public void testGetQuestionByList() throws Exception
	{
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question);
		List<QueAndAns> queAndAns = new ArrayList<>();
		queAndAns.add(QueAndAns.builder().question(question).AnswerList(new ArrayList<Answers>()).build());
		Mockito.when(questionRepo.getQuestionList(category.getCat_name(), subCat.getSubcat_name())).thenReturn(questionList);
		assertEquals(questionService.getDataByCategory(category.getCat_name(), subCat.getSubcat_name()).size(), 1);
	}
}
