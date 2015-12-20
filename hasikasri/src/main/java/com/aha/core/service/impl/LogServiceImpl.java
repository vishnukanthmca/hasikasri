package com.aha.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.Log;
import com.aha.core.service.LogService;
import com.aha.persistence.repository.LogRepository;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogRepository logRepository;

	@Override
	public Log save(Log databaseLog) {
		return logRepository.save(databaseLog);
	}

}
