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
import com.aha.web.dto.request.GetProductsInputDto;
import com.aha.web.dto.response.FilterDto;
import com.aha.web.dto.response.ProductDto;
import com.google.gson.Gson;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/findProducts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String findByPid(@RequestParam("page") Integer page,
			@RequestBody GetProductsInputDto input) {

		if (input.getCategoryIds() == null || input.getCategoryIds().isEmpty()
				|| input.getAttributeIds() == null
				|| input.getAttributeIds().isEmpty() || page < 0) {
			return null;
		}

		if (!input.isValidSort()) {
			return "Not an authenticated sort";
		}

		List<Product> products = productService.findByCategoryIds(input, page);

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
	public @ResponseBody String getRefiners(
			@RequestBody GetProductsInputDto input) {

		if (input.getCategoryIds() == null || input.getCategoryIds().isEmpty()
				|| input.getAttributeIds() == null
				|| input.getAttributeIds().isEmpty()) {
			return null;
		}

		if (!input.isValidSort()) {
			return "Not an authenticated sort";
		}

		FilterDto dto = productService.getAllRefinersByCategory(input, 0);
		return new Gson().toJson(dto);
	}
}
