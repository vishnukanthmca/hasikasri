package com.aha.core.service;

import java.util.List;

import com.aha.core.domain.Category;

public interface CategoryService {

	final static Boolean ACTIVE = true;
	
	List<Category> findActiveCategories();

}
