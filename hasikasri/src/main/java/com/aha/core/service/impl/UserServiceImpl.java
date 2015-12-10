package com.aha.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.User;
import com.aha.core.service.UserService;
import com.aha.persistence.repository.UserRepository;
import com.aha.web.dto.request.RegisterInputDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User persistUser(RegisterInputDto dto) {
		return repository.save(dto.getUser());
	}

	@Override
	public User findUserByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public User findUserByMobile(String mobile) {
		return repository.findByMobile(mobile);
	}

	@Override
	public boolean isUserPresent(String email, String mobile) {
		if (this.findUserByEmail(email) != null
				|| this.findUserByMobile(mobile) != null) {
			return true;
		}

		return false;
	}
}
