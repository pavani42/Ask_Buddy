package com.hcl.ask_buddy.answer.service;

import java.util.List;

import com.hcl.ask_buddy.answer.entity.Answers;

public interface AnswerService {
	public Answers postAnswer(long id, String question, String Answer);
	public List<Answers> getAnswers(String question);
	public Answers getAnswersById(long id);
	public String updateAnswer(long id, String answer);
	public String deleteAnswer(long id); 
	
}
