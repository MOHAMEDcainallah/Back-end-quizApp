package com.exam.tablesdiawli.tabledialquizz;

import java.util.List;

public class Scoring {
	
	private Integer correctAnswers;
	
	private double marksObtained;
	
	private Integer attempted;
	
	private List<LesQuestions> questions;

	public Integer getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(Integer correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public double getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(double marksObtained) {
		this.marksObtained = marksObtained;
	}

	public Integer getAttempted() {
		return attempted;
	}

	public void setAttempted(Integer attempted) {
		this.attempted = attempted;
	}

	public List<LesQuestions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<LesQuestions> questions) {
		this.questions = questions;
	}

	public Scoring(Integer correctAnswers, double marksObtained, Integer attempted,
				   List<LesQuestions> questions) {
		super();
		this.correctAnswers = correctAnswers;
		this.marksObtained = marksObtained;
		this.attempted = attempted;
		this.questions = questions;
	}

	public Scoring() {
		
	}
	
	
	
	

}
