package com.aha.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aha.core.service.SearchService;
import com.aha.web.dto.response.SearchDto;
import com.google.gson.Gson;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchService searchService;

	@RequestMapping(value = "/getTerms", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllCategories(
			@RequestParam("query") String query) {

		searchService.startIndexing();
		List<SearchDto> dtos = searchService.query(query);

		System.out.println(dtos);

		return new Gson().toJson(dtos);
	}
}
