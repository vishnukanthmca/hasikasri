package com.aha.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.Category;
import com.aha.core.service.CategoryService;
import com.aha.persistence.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findActiveCategories() {
		Category category = new Category();
		//category.setTemporaryDate(new java.sql.Date(year, month, day));
		
		categoryRepository.save(category);
		return null;//categoryRepository.findByActive(ACTIVE);
	}
}
