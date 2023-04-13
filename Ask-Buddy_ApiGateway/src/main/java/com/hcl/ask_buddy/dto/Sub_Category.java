package com.hcl.ask_buddy.dto;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class Sub_Category {  

	// DTO for Sub_Category
	private long id;
	public Sub_Category(long id, String subcat_name, Category category) {
		super();
		this.id = id;
		this.subcat_name = subcat_name;
		this.category = category;
	}
	private String subcat_name;
	private Category category;
	@JsonIgnore
	private List<Question> questionList;
}
