package com.aha.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aha.core.service.CategoryService;

@Controller
public class HomeController {

	private static final String HOME_PAGE = "home";
	private static final String LISTING_PAGE = "listing";
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/home")
	public ModelAndView home() {
		// TODO - implment the method

		categoryService.findActiveCategories();
		System.out.println("inside controller..");
		
		ModelAndView modelAndView = new ModelAndView(HOME_PAGE);
		return modelAndView;
	}
	
	@RequestMapping(value = "/listing")
	public ModelAndView listing() {
		// TODO - implment the method

		System.out.println("inside controller..");
		
		ModelAndView modelAndView = new ModelAndView(LISTING_PAGE);
		return modelAndView;
	}
}
