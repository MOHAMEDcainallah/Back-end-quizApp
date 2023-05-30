package com.exam.finkansawbolesfonctions;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.tablesdiawli.tabledialquizz.LesQuestions;
import com.exam.tablesdiawli.tabledialquizz.Quiz;

@Service
public interface QuestionService {
	
	public LesQuestions addQuestion(LesQuestions question);
	
	public LesQuestions updateQuestion(LesQuestions question);
	
	public Set<LesQuestions> getQuestions();
	
	public Set<LesQuestions> questionsOfQuiz(Quiz quiz);
	
	public void deletequestion(Long quesId) throws Exception;
	
	public LesQuestions getQuestionById(Long quesId) throws Exception;
}
