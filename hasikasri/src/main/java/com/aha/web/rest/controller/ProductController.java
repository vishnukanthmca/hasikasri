package com.aha.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aha.core.domain.Product;
import com.aha.core.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/findProducts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String findByPid(@RequestBody List<Long> categoryIds) {

		if (categoryIds == null || categoryIds.isEmpty()) {
			return null;
		}

		List<Product> products = productService.findByCategoryIds(categoryIds);

		if (products == null || products.isEmpty()) {
			return null;
		}

		for (Product product : products) {
			System.out.println("product " + product);
		}

		for (int i = 0; i < categoryIds.size(); i++) {
			Long long1 = categoryIds.get(i);
			System.out.println("long1 " + long1);
		}

		return null;
	}
}
