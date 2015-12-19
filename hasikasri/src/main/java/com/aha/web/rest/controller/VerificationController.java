package com.aha.web.rest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aha.core.service.VerificationService;

@Controller
public class VerificationController {

	@Autowired
	private VerificationService verificationService;

	@RequestMapping("/sendSms")
	public @ResponseBody String sendSms(HttpSession session,
			@RequestParam("mobile") String mobile) {

		if (session.getAttribute("userId") == null) {
			if (session != null) {
				session.invalidate();
			}
			return "unauthorized";
		}

		int code = verificationService.generateRandomNo();

		System.out.println("code " + code);

		session.setAttribute(mobile, code);

		if (verificationService.sendSMS(mobile)) {
			return "verificationcodesent";
		}

		return "true";
	}

	@RequestMapping("/verifyMobile")
	public @ResponseBody String verifyMobile(HttpSession session,
			@RequestParam("mobile") String mobile, String code) {

		if (session.getAttribute("userId") == null) {
			if (session != null) {
				session.invalidate();
			}
			return "unauthorized";
		}

		Integer sessionCode = (Integer) session.getAttribute(mobile);

		if (sessionCode == null) {
			if (session != null) {
				session.invalidate();
			}
			return "malfunctioned";
		}

		if (sessionCode.toString().equals(code)) {
			return "success";
		}

		return "failed";
	}
}
