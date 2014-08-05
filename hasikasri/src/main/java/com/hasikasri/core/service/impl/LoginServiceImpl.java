package com.hasikasri.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasikasri.core.domain.User;
import com.hasikasri.core.service.LoginService;
import com.hasikasri.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean login(User currentUser) {

		boolean isAuthenticated = false;

		User user = userRepository.findByUsernameAndPassword(currentUser);

		if (user != null) {
			isAuthenticated = true;
		}

		logger.debug("User authentication is successful for username " + user);

		return isAuthenticated;
	}
}
