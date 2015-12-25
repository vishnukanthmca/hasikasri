package com.aha.web.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(value = IllegalStateException.class)
	public String handleIllegalStateExceptions() {
		return "home";
	}
}
