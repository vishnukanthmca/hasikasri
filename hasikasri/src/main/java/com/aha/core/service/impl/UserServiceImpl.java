package com.aha.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.User;
import com.aha.core.service.UserService;
import com.aha.core.util.Util;
import com.aha.persistence.repository.UserRepository;
import com.aha.web.dto.request.LoginDto;
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

	@Override
	public User login(LoginDto dto) {
		User user = null;
		try {
			Long.parseLong(dto.getEmailOrMobile());
			user = repository.findByMobile(dto.getEmailOrMobile());
			if (user != null) {
				boolean authenticated = Util.decodePassword(dto.getPassword(),
						user.getPassword());
				if (authenticated) {
					return user;
				}
			}
		} catch (NumberFormatException e) {
			user = repository.findByEmail(dto.getEmailOrMobile());
			if (user != null) {
				boolean authenticated = Util.decodePassword(dto.getPassword(),
						user.getPassword());
				if (authenticated) {
					return user;
				}
			}
		}

		return null;
	}

	@Override
	public Boolean isUserPresent(LoginDto dto) {
		try {
			Long.parseLong(dto.getEmailOrMobile());
			if (this.findUserByMobile(dto.getEmailOrMobile()) != null) {
				return true;
			}
		} catch (NumberFormatException e) {
			if (this.findUserByEmail(dto.getEmailOrMobile()) != null) {
				return true;
			}
		}

		return false;
	}

	@Override
	public User findOne(Long userId) {
		return repository.findOne(userId);
	}
}
