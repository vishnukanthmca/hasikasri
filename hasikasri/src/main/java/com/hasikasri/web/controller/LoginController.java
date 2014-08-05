package com.hasikasri.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hasikasri.core.domain.User;
import com.hasikasri.core.service.LoginService;


@ComponentScan(basePackages = {"com.hasikasri"})
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(method = RequestMethod.POST, value = "login")
	public ModelAndView login(@ModelAttribute User user, ModelMap modelMap,
			BindingResult bindingResult) {

		ModelAndView modelAndView = null;

		if (bindingResult.hasErrors()) {
			modelAndView = new ModelAndView("login", "command", user);
		}

		if (loginService.login(user)) {
			modelAndView = new ModelAndView("home", "command", user);
		} else {
			modelAndView = new ModelAndView("nopermission", "command", user);
		}

		return modelAndView;
	}
}
