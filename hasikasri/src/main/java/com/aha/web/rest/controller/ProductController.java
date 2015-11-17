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
import com.aha.web.dto.response.ProductDto;
import com.aha.web.dto.response.RefinerDto;
import com.google.gson.Gson;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/findProducts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String findByPid(@RequestParam("page") Integer page,
			@RequestBody GetProductsInputDto input) {

		System.out.println("attributeIds " + input.getAttributeIds()
				+ " categoryIds " + input.getCategoryIds());

		if (input.getCategoryIds() == null || input.getCategoryIds().isEmpty()
				|| input.getAttributeIds() == null
				|| input.getAttributeIds().isEmpty() || page < 0) {
			return null;
		}

		List<Product> products = productService.findByCategoryIds(
				input.getCategoryIds(), input.getAttributeIds(), page);

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

		List<RefinerDto> refiners = productService.getAllRefinersByCategory(
				input.getCategoryIds(), input.getAttributeIds(), 0);
		refiners.forEach(r -> {
			r.getUniqueAttributes().forEach(
					a -> {
						a.getAttributeIds().forEach(
								id -> {
									System.out.println("id -> " + id
											+ " | for refiner -> " + r
											+ " | for attribute -> " + a);
								});
					});
		});

		return new Gson().toJson(refiners);
	}
}
