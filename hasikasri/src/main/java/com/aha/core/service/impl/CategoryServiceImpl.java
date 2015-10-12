package com.aha.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.Attribute;
import com.aha.core.domain.Category;
import com.aha.core.domain.Refiner;
import com.aha.core.service.CategoryService;
import com.aha.persistence.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category findActiveCategories(Long id) {
		return categoryRepository.findByActive(ACTIVE, id);
	}

	public void saveRefiner() {

		Refiner refiner = new Refiner();
		refiner.setName("FARIC");

		Attribute attribute = new Attribute();
		attribute.setName("Cotton");
		attribute.setRefiner(refiner);

		List<Attribute> attributes = new ArrayList<>();
		attributes.add(attribute);

		Category category = new Category();
		category.setId(6L);
		category.setName("Women's Clothing");
		category.setActive(true);

		Category parentCategory = categoryRepository.findOne(4L);

		category.setParentCategory(parentCategory);

		// category.setAttributes(attributes);

		categoryRepository.save(category);

	}
}
