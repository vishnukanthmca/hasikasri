package com.hasika.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hasika.dto.Result;
import com.hasika.dto.User;

@Controller
public class SampleController {

	@RequestMapping(method = RequestMethod.GET, value = "login")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView result = new ModelAndView("login");
		result.addObject("result", new Result());
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "home")
	public String login(@ModelAttribute("user") User user, BindingResult result) {
		return "login";
	}
}
