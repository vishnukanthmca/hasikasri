package com.aha.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aha.core.service.ImageService;
import com.aha.core.service.ProductService;

@Controller
public class HomeController {

	private static final String HOME_PAGE = "home";
	private static final String LISTING_PAGE = "listing";
	private static final String ERROR_PAGE = "error";

	@Autowired
	private Facebook faceBook;

	@Autowired
	private ProductService productService;

	@Autowired
	private ImageService imageService;

	@RequestMapping(value = "/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView(HOME_PAGE);
		return modelAndView;
	}

	@RequestMapping(value = "/listing")
	public ModelAndView listing() {
		ModelAndView modelAndView = new ModelAndView(LISTING_PAGE);
		return modelAndView;
	}

	@RequestMapping(value = "/error")
	public ModelAndView error() {
		ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
		return modelAndView;
	}
}
