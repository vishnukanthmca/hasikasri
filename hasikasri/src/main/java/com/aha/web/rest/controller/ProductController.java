package com.aha.web.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aha.core.domain.Product;
import com.aha.core.service.ProductService;
import com.aha.web.dto.ProductDto;
import com.aha.web.dto.RefinerDto;
import com.google.gson.Gson;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/findProducts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String findByPid(@RequestBody List<Long> categoryIds,
			@RequestParam("page") Integer page) {

		if (categoryIds == null || categoryIds.isEmpty() || page < 0) {
			return null;
		}

		List<Product> products = productService.findByCategoryIds(categoryIds,
				page);

		if (products == null || products.isEmpty()) {
			return null;
		}

		List<ProductDto> dtos = new ArrayList<ProductDto>();

		products.forEach(p -> {
			ProductDto dto = new ProductDto(p);
			dtos.add(dto);
		});

		return new Gson().toJson(dtos);
	}

	@RequestMapping(value = "/findRefiners", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getRefiners(@RequestBody List<Long> categoryIds) {

		if (categoryIds == null || categoryIds.isEmpty()) {
			return null;
		}

		List<RefinerDto> refiners = productService.getAllRefinersByCategory(
				categoryIds, 0);
		return new Gson().toJson(refiners);
	}
}
