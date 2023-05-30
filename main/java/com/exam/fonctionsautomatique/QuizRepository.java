package com.exam.fonctionsautomatique;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.tablesdiawli.tabledialquizz.CategoriesDialQuizz;
import com.exam.tablesdiawli.tabledialquizz.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

	List<Quiz> findQuizzesByCategory(CategoriesDialQuizz category);
	
	List<Quiz> findByActive(boolean active);
	
	List<Quiz> findByCategoryAndActive(CategoriesDialQuizz category, boolean active);
}
