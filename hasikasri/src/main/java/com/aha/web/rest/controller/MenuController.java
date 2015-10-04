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
import com.aha.web.dto.MenuDto;
import com.google.gson.Gson;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/allCategories", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllCategories() {

		System.out.println("inside menu controller..");
		List<Category> categories = null;// categoryService.findActiveCategories();

		List<CategoryDto> categoriesDtos = new ArrayList<>();

		if (categories != null && !categories.isEmpty()) {
			// for (Category category : categories) {
			// CategoryDto dto = new CategoryDto(category.getId(),
			// category.getName(), category.getParentCategory());
			// categoriesDtos.add(dto);
			// }
		}

		MenuDto menuDto = new MenuDto(null);

		return new Gson().toJson(menuDto);
	}
}
