package com.aha.core.service;

import com.aha.core.domain.Category;

public interface CategoryService {

	final static Boolean ACTIVE = true;

	Category findActiveCategories(Long id);

	public Category findByProductId(Long productId);
}
