package com.hcl.ask_buddy.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class QueAndAns {

	// DTO for Question And Answer
	private Question question;
	private List<Answers> AnswerList;
	
}
