package com.exam.tablesdiawli.tabledialquizz;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long qid;
	
	private String title;
	
	private String description;
	
	private String numberOfQuestions;
	
	private String maxMarks;
	
	private boolean active=false;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private CategoriesDialQuizz category;
	
	@OneToMany(mappedBy="quiz",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<LesQuestions> question=new HashSet<>();

	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public String getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	

	public CategoriesDialQuizz getCategory() {
		return category;
	}

	public void setCategory(CategoriesDialQuizz category) {
		this.category = category;
	}

	public Set<LesQuestions> getQuestion() {
		return question;
	}

	public void setQuestion(Set<LesQuestions> question) {
		this.question = question;
	}

	public Quiz() {
	}

	public Quiz(Long qid, String title, String description, String numberOfQuestions, String maxMarks, boolean active,
				CategoriesDialQuizz category, Set<LesQuestions> question) {
		super();
		this.qid = qid;
		this.title = title;
		this.description = description;
		this.numberOfQuestions = numberOfQuestions;
		this.maxMarks = maxMarks;
		this.active = active;
		this.category = category;
		this.question = question;
	}
	
	
	
	

}
