package com.hcl.ask_buddy.question.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hcl.ask_buddy.question.entity.Answers;
import com.hcl.ask_buddy.question.entity.Question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class QueAndAns {
	private Question question;
	private List<Answers> AnswerList;
	
}
