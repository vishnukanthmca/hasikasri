package com.aha.web.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aha.core.domain.Category;
import com.aha.core.service.CategoryService;
import com.aha.web.dto.CategoryDto;
import com.google.gson.Gson;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/allCategories", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllCategories() {

		System.out.println("inside menu controller..");
		List<Category> categories = categoryService.findActiveCategories();
		
		List<CategoryDto> categoriesDtos = new ArrayList<>();
		for (Category category : categories) {
			categoriesDtos.add(new CategoryDto(category));
		}
		
		CategoryDto dto = new CategoryDto(null);
		List<CategoryDto> l = new ArrayList<>();
		l.add(dto);
	
		return new Gson().toJson(dto);
	}
}
