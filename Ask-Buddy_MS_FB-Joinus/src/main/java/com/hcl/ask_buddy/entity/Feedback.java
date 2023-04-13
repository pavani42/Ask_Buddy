package com.hcl.ask_buddy.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "timestamp", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime dtntm;
	@NotNull
	private int rating;
//	@Digits(integer = 8, fraction = 0)
//	private long sapId;
	@Column(name = "UserReviews", columnDefinition = "varchar(550)")
	private String cmnts;
	@Column(name = "Suggestions", columnDefinition = "varchar(550)")
	private String anyImp;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "sap_id")
	private User user;

}
