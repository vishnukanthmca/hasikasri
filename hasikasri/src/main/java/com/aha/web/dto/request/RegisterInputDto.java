package com.aha.web.dto.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class RegisterInputDto {

	@Email
	@NotBlank
	private String email;

	@NotBlank
	@Pattern(regexp = "[\\d]{10}")
	private String mobile;

	@NotBlank
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegisterInputDto [email=" + email + ", mobile=" + mobile
				+ ", password=" + "]";
	}

}
