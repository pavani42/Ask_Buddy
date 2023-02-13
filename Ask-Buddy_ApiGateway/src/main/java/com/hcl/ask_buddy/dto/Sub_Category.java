package com.hcl.ask_buddy.dto;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Sub_Category {  
	
	private long id;
	private String subcat_name;
	private Category category;
	@JsonIgnore
	private List<Question> questionList;
}
