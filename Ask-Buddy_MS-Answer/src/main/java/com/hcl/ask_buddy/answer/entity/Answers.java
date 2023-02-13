package com.hcl.ask_buddy.answer.entity;


import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "answers")
public class Answers {
	@Id
	@Column(name = "ans_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	@JoinColumn(name = "que_id", referencedColumnName = "que_id")
	private Question question;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "sap_id")
	private User user;
	@Column(name = "ans_description")
	private String description;
	@Column(name = "ans_date")
	private LocalDateTime date;	
	
}
