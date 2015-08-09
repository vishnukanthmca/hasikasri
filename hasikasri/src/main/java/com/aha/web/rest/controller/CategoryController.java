package com.aha.web.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aha.core.service.CategoryService;
import com.aha.web.dto.CategoryDto;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/allCategories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllCategories() {
		// TODO - implment the method

		System.out.println("inside controller..");
		categoryService.findAll();

		CategoryDto dto = new CategoryDto(null);
		List<CategoryDto> l = new ArrayList<>();
		l.add(dto);
		// Gson s = new Gson();
		return "hello";
	}
}
