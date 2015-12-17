package com.aha.core.service;

import com.aha.web.dto.request.ReturnInputDto;

public interface ReturnOrderService {

	void save(ReturnInputDto dto, Long userId);
}
