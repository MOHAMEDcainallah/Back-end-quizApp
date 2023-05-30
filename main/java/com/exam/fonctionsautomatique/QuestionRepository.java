package com.exam.fonctionsautomatique;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.tablesdiawli.tabledialquizz.LesQuestions;
import com.exam.tablesdiawli.tabledialquizz.Quiz;

@Repository
public interface QuestionRepository extends JpaRepository<LesQuestions, Long> {
	
	Set<LesQuestions> findByQuiz(Quiz quiz);

}
