package com.aha.core.service.impl;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.service.SearchService;
import com.aha.persistence.repository.SearchRepository;
import com.aha.web.dto.response.SearchDto;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchRepository repository;

	@Override
	public void startIndexing() {
		repository.startIndexing();
	}

	@Override
	public List<SearchDto> query(String searchTerm) {

		searchTerm = removeStopWords(searchTerm);

		if (searchTerm == null || searchTerm.isEmpty()) {
			return null;
		}

		List<SearchDto> dtos = new ArrayList<SearchDto>();
		String[] words = searchTerm.split(" ");

		System.out.println("words " + words.length);

		if (words != null && words.length > 1) {
			for (String s : words) {
				if (s != null && !s.trim().isEmpty()) {
					dtos.addAll(repository.query(s));
				}
			}
		} else if (words != null && words.length == 1) {
			dtos.addAll(repository.query(searchTerm));
		}

		return dtos;
	}

	private String removeStopWords(String sentence) {

		String out = "";

		Analyzer analyzer = new StopAnalyzer();
		TokenStream stream;
		try {
			stream = analyzer.tokenStream("", new StringReader(sentence));
			stream.reset();
			while (stream.incrementToken()) {
				out += stream.getAttribute(CharTermAttribute.class).toString()
						+ " ";
			}

			analyzer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return out.trim();
	}
}
