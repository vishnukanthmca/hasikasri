package com.aha.core.service;

import com.aha.core.domain.User;
import com.aha.web.dto.request.RegisterInputDto;

public interface UserService {

	public User persistUser(RegisterInputDto dto);

	public User findUserByEmail(String email);

	public User findUserByMobile(String email);

	public boolean isUserPresent(String email, String mobile);
}
