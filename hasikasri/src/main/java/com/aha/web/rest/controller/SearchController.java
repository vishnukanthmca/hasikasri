package com.aha.web.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aha.core.service.CategoryService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/getTerms", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllCategories(
			@RequestParam("query") String query) {
		System.out.println("query " + query);
		List<Dto> dtos = new ArrayList<>();

		Dto dto = new Dto();
		dto.setName("Abcd");
		dto.setId(1);

		dtos.add(dto);

		dto = new Dto();
		dto.setName("Abc");
		dto.setId(2);

		dtos.add(dto);

		dto = new Dto();
		dto.setName("Abcedefhgh");
		dto.setId(2);

		dtos.add(dto);

		dto = new Dto();
		dto.setName("Abcdfdsfkndf");
		dto.setId(2);

		dtos.add(dto);

		dto = new Dto();
		dto.setName("Abcsdfksfkdsfds");
		dto.setId(2);

		dtos.add(dto);

		
		return new Gson().toJson(dtos);
	}
}

class Dto {

	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
