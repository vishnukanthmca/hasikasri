package com.aha.web.dto.request;

import org.hibernate.validator.constraints.NotBlank;

public class LoginDto {

	@NotBlank
	private String emailOrMobile;

	@NotBlank
	private String password;

	public String getEmailOrMobile() {
		return emailOrMobile;
	}

	public void setEmailOrMobile(String emailOrMobile) {
		this.emailOrMobile = emailOrMobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDto [emailOrMobile=" + emailOrMobile + ", password="
				+ password + "]";
	}
}
