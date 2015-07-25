package com.aha.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aha.core.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/findProduct", method = RequestMethod.POST)
	public @ResponseBody String findByPid(@RequestParam("pid") String pid) {

		System.out.println("inside controller.." + pid);
		productService.findByPid(pid);

		return pid;
	}
}
