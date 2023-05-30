package com.exam.finkansawbolesfonctions.servicesdialquizz;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.tablesdiawli.tabledialquizz.CategoriesDialQuizz;
import com.exam.fonctionsautomatique.CategoryRepository;
import com.exam.finkansawbolesfonctions.CategoryService;

@Service()
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired 
	private CategoryRepository categoryRepository;

	@Override
	public CategoriesDialQuizz addCategory(CategoriesDialQuizz category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public CategoriesDialQuizz updateCategory(CategoriesDialQuizz category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<CategoriesDialQuizz> getCategories() {
		
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public void deleteCategory(Long cid) throws Exception {
		this.categoryRepository.deleteById(cid);

	}

	@Override
	public CategoriesDialQuizz getCategoryById(Long cid) throws Exception {
		CategoriesDialQuizz category=this.categoryRepository.findById(cid).get();
		System.out.println("category data fetch from db is "+category.getTitle()+" "+category.getDescription()+" "+category.getCid());
		return category;
	}

}
