package com.hcl.ask_buddy.entity;

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

	// User Entity Attributes
	@Id
	@Column(name = "sap_id")
	private long sap_Id;
	@Column(name = "user_mail")
	private String mail;
	public User(long sap_Id, String mail, String username, String password) {
		super();
		this.sap_Id = sap_Id;
		this.mail = mail;
		this.username = username;
		this.password = password;
	}
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
