package com.exam.finkansawbolesfonctions;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.tablesdiawli.tabledialquizz.CategoriesDialQuizz;
import com.exam.tablesdiawli.tabledialquizz.Quiz;

@Service
public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizzes();
	
	public Quiz getQuizById(Long qid) throws Exception;
	
	public void deleteQuiz(Long qid) throws Exception;

	public List<Quiz> findQuizzesByCategoryId(CategoriesDialQuizz category);
	
	public List<Quiz> findAllActiveQuiz();
	
	public List<Quiz> findAllActiveQuizOfCategory(CategoriesDialQuizz category);

}
