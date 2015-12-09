package com.aha.core.service;

import com.aha.web.dto.request.RegisterInputDto;

public interface UserService {

	public void persistUser(RegisterInputDto dto);
}
