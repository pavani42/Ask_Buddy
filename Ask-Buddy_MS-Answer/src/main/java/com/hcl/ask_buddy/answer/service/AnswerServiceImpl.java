package com.hcl.ask_buddy.answer.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hcl.ask_buddy.answer.entity.Answers;
import com.hcl.ask_buddy.answer.exception.ResourceNotFoundException;
import com.hcl.ask_buddy.answer.repository.*;
import com.hcl.ask_buddy.answer.security.AuthenticatedUser;

@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	AnswerRepo answerRepo;

	@Autowired
	QuestionsRepo questionRepo; 

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AuthenticatedUser authenticatedUser;


	@Override
	public Answers postAnswer(long id, String question, String answerDesc) {
		Answers answer = new Answers();
		answerDesc = answerDesc.trim();
		answer.setQuestion(questionRepo.getQuestionByQuestion(question));
		answer.setDescription(answerDesc);
		answer.setDate(LocalDateTime.now());
		answer.setUser(authenticatedUser.getUser());
		answerRepo.save(answer);
		return answer;
	}

	@Override
	public List<Answers> getAnswers(String ques) {
//		System.out.println(ques);
		List<Answers> answers = answerRepo.getAnswerByQuestion(ques);
		if(answers.size() > 0)
			return answers;
		else
			throw new ResourceNotFoundException("Given Question is not found");
	}

	@Override
	public Answers getAnswersById(long id) {
		
		return answerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Answer Id is not found in the list"));

	}

	@Override
	public String updateAnswer(long id, String answer) {
		answer = answer.trim();
		answerRepo.updateAnswer(authenticatedUser.getUser().getSap_Id(), answer);
		return "Successfully Updated";	
	}

	@Override
	public String deleteAnswer(long id) {
		answerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Given Id Not found"));
		try
		{
			answerRepo.deleteById(authenticatedUser.getUser().getSap_Id());
			return "Successfully Deleted";
		}
		catch(Exception e)
		{
			throw new ResourceNotFoundException(e.getMessage());
	    }
		
	}

}
