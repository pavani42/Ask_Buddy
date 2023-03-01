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
	AuthenticatedUser authUser;


	@Override
	public Answers postAnswer(String question, String answerDesc) {
		answerDesc = answerDesc.trim();
		System.out.println(userRepo.findById(authUser.getUser().getSap_Id()).get());
		Answers answer = Answers.builder().question(questionRepo.getQuestionByQuestion(question)).description(answerDesc)
				.date(LocalDateTime.now()).user(userRepo.findById(authUser.getUser().getSap_Id()).get()).build();

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
		answerRepo.updateAnswer(id, answer);
		return "Successfully Updated";	
	}

	@Override
	public String deleteAnswer(long id) {
		answerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Given Id Not found"));
		if(answerRepo.findById(id).get().getUser().getSap_Id() == authUser.getUser().getSap_Id())
		{
		   answerRepo.deleteById(id);
		   return "Successfully Deleted";
		}
		else
		{
			return "Unauthorized User";
		}


	}

}
