package com.aha.core.service;

import java.util.List;

import com.aha.core.domain.Description;

public interface DescriptionService {

	public List<Description> getdDescriptionsByProduct(Long productId);
}
