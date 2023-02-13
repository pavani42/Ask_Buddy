package com.hcl.ask_buddy.answer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "sap_id")
	private long sap_Id;
	@Column(name = "user_mail")
	private String mail;
	@Column(name = "user_name")
	private String username;
	@Column(name = "password")
	private String password;
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Question> questionList;
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Answers> answerList;

}
