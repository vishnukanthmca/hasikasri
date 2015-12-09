package com.aha.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aha.web.dto.request.RegisterInputDto;

@Controller
public class RegisterController {

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public @ResponseBody String join(
			@ModelAttribute("form") @Valid RegisterInputDto dto) {

		System.out.println(dto);

		return "join";
	}
}
