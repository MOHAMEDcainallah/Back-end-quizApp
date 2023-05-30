package com.exam.finkansawbolesfonctions;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.tablesdiawli.tabledialquizz.CategoriesDialQuizz;

@Service()
public interface CategoryService {
	
	public CategoriesDialQuizz addCategory(CategoriesDialQuizz category);
	
	public CategoriesDialQuizz updateCategory(CategoriesDialQuizz category);
	
	public Set<CategoriesDialQuizz> getCategories();
	
	public void deleteCategory(Long cid) throws Exception;
	
	public CategoriesDialQuizz getCategoryById(Long cid) throws Exception;

}
