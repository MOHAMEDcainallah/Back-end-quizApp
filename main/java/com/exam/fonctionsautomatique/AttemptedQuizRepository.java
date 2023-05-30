package com.exam.fonctionsautomatique;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.tablesdiawli.tabledialquizz.QuizzLiDkhelt;

@Repository
public interface AttemptedQuizRepository extends JpaRepository<QuizzLiDkhelt, Long> {

}
