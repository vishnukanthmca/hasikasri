package com.aha.core.service;

import java.util.List;

import com.aha.web.dto.response.SearchDto;

public interface SearchService {

	public void startIndexing();

	public List<SearchDto> query(String searchTerm);
}
