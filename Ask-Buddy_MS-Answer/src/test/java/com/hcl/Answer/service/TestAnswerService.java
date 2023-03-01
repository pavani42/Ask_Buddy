package com.hcl.Answer.service;

import java.time.LocalDateTime;
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

import com.hcl.ask_buddy.answer.entity.*;
import com.hcl.ask_buddy.answer.exception.ResourceNotFoundException;
import com.hcl.ask_buddy.answer.repository.AnswerRepo;
import com.hcl.ask_buddy.answer.repository.QuestionsRepo;
import com.hcl.ask_buddy.answer.repository.UserRepo;
import com.hcl.ask_buddy.answer.service.AnswerServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestAnswerService {
	
	@InjectMocks
	AnswerServiceImpl answerService;
	
	@Mock
	AnswerRepo answerRepo;
	
	@Mock
	UserRepo userRepo;
	
	@Mock
	QuestionsRepo questionRepo;
	
	
	Answers answer;
	
	User user;
	
	Question question;
	
	@BeforeEach
	public void setUp()
	{
		user = User.builder().sap_Id(52112593).mail("test@gmail.com").username("test").password("$2a$10$x3/ufTsGe5GWleD334csK.9rY1xiIGqP4lEV4VlB6WXQR9ff6bxqW").build();
//		userRepo.save(user);
		question = Question.builder().quesDescription("What is abstraction?").question("What is abstraction?").user(user).date(LocalDateTime.now()).build();
//		questionRepo.save(question);
		answer = Answers.builder().id(1).description("Hiding the details").date(LocalDateTime.now())
				.question(question).user(user).build();
	}
	
	@Test
	public void testPostAnswer()
	{
		Mockito.when(answerRepo.save(Mockito.any(Answers.class))).thenReturn(answer);
		Mockito.when(userRepo.findById(52112593)).thenReturn(Optional.of(user));
		Mockito.when(questionRepo.getQuestionByQuestion(answer.getQuestion().getQuestion())).thenReturn(question);		
		Answers savedAnswer = answerService.postAnswer(answer.getQuestion().getQuestion(), answer.getDescription());
		assertThat(savedAnswer).isNotNull();
		
	}
	
	@Test
	public void testgetAnswers()
	{
		List<Answers> answerList = new ArrayList<Answers>();
		answerList.add(answer);
		Mockito.when(answerRepo.getAnswerByQuestion(answer.getQuestion().getQuestion())).thenReturn(answerList);
		assertEquals(answerService.getAnswers(answer.getQuestion().getQuestion()), answerList);
	}
	
	@Test
	public void testGetAnswersException()
	{
		org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			answerService.getAnswers("what is inheritance");
		});	
	}
	
	@Test
	public void testGetAnswersById()
	{
		Mockito.when(answerRepo.findById((long) 1)).thenReturn(Optional.of(answer));
		assertEquals(answerService.getAnswersById(1), answer);
	}
	
	@Test
	public void testUpdateAnswer()
	{
		Mockito.when(answerRepo.updateAnswer(1, "Hiding the data")).thenReturn(5);
//		Mockito.when(userRepo.findById(52112593)).thenReturn(Optional.of(user));
		assertEquals(answerService.updateAnswer(1, "Hiding the data"), "Successfully Updated");
	}
	
	@Test
	public void testDeleteAnswer_throwsException()
	{
//		Mockito.when(answerRepo.findById((long) 2)).thenReturn(Optional.of(answer));
////		assertEquals(answerService.deleteAnswer(1), "Successfully Deleted");
//		AuthenticatedUser authuser = new AuthenticatedUser();
//		authuser.setUser(user);
		org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			answerService.deleteAnswer(2);
		});	
//		assertEquals(answerService.deleteAnswer(1), "Successfully Deleted");
	}
	
	@Test
	public void testDeleteAnswer()
	{
		Mockito.when(answerRepo.findById((long) 1)).thenReturn(Optional.of(answer));
	 	assertEquals(answerService.deleteAnswer(1), "Successfully Deleted");
		
	}
	
	

}
