package com.aha.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aha.core.domain.User;
import com.aha.core.service.UserService;
import com.aha.web.dto.request.AccountDto;
import com.aha.web.dto.request.LoginDto;
import com.aha.web.dto.request.RegisterInputDto;

@Controller
public class LoginAndRegisterController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView join(@ModelAttribute("form") @Valid RegisterInputDto dto) {

		ModelAndView view = new ModelAndView();
		view.setViewName("register");

		if (userService.isUserPresent(dto.getEmail(), dto.getMobile())) {
			view.addObject("userExists", true);
			return view;
		}

		userService.persistUser(dto);

		view.setViewName("redirect:home");

		return view;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String login(HttpSession session,
			@RequestBody LoginDto dto) {

		if (!userService.isUserPresent(dto)) {
			return "notregistered";
		}

		User user = userService.login(dto);

		if (user != null) {

			int index = user.getEmail().indexOf("@");
			if (index > 0) {
				session.setAttribute("user", user.getEmail()
						.substring(0, index));
				session.setAttribute("userId", user.getId());
			}

			return "true";
		} else {
			return "false";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return "home";
	}

	@RequestMapping("/myaccount")
	public ModelAndView myaccount(HttpSession session) {

		ModelAndView view = new ModelAndView();

		if (session.getAttribute("userId") == null) {
			view.setViewName("home");
			return view;
		}

		Long userId = Long.parseLong(session.getAttribute("userId").toString());
		view.setViewName("account");

		User user = userService.findOne(userId);

		if (user == null) {
			view.setViewName("logout");
			return view;
		}

		AccountDto dto = new AccountDto();
		dto.setEmail(user.getEmail());
		dto.setMobile(user.getMobile());
		dto.setName(user.getName());

		view.addObject("user", dto);

		return view;
	}
}
