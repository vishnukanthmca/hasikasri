package com.aha.core.service;

import com.aha.core.domain.User;
import com.aha.web.dto.request.LoginDto;
import com.aha.web.dto.request.RegisterInputDto;

public interface UserService {

	public User persistUser(RegisterInputDto dto);

	public User findUserByEmail(String email);

	public User findUserByMobile(String email);

	public boolean isUserPresent(String email, String mobile);

	public Boolean isUserPresent(LoginDto dto);

	public User login(LoginDto dto);

	public User findOne(Long userId);

	public User saveUser(User user);
}
