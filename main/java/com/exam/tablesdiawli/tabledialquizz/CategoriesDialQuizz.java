package com.exam.tablesdiawli.tabledialquizz;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CategoriesDialQuizz {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cid;
	
	private String title;
	
	private String description;
	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Quiz> quizzes=new LinkedHashSet<>();

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
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

	

	public CategoriesDialQuizz(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public Set<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(Set<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public CategoriesDialQuizz() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
