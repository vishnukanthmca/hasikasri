package com.hasika.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hasika.web.dto.User;

@Controller
public class SampleController {

	@RequestMapping(method = RequestMethod.GET, value = "login")
	public ModelAndView index(HttpServletRequest request) {
		return new ModelAndView("login", "command", new User());
	}

	@RequestMapping(method = RequestMethod.POST, value = "home")
	public String login(@ModelAttribute("user") User user, ModelMap modelMap,
			BindingResult bindingResult) {

		modelMap.addAttribute("user", user);

		return "home";
	}
}
