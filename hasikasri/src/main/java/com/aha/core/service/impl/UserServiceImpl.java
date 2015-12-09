package com.aha.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.service.UserService;
import com.aha.persistence.repository.UserRepository;
import com.aha.web.dto.request.RegisterInputDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public void persistUser(RegisterInputDto dto) {
		repository.save(dto.getUser());
	}
}
