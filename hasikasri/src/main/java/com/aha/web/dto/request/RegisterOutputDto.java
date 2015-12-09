package com.aha.web.dto.request;

import org.hibernate.validator.constraints.Email;

public class RegisterOutputDto {

	@Email
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
