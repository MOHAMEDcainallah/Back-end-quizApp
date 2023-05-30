package com.exam.fonctionsautomatique;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.tablesdiawli.tabledialquizz.CategoriesDialQuizz;

@Repository
public interface CategoryRepository extends JpaRepository<CategoriesDialQuizz, Long> {

}
