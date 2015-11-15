package com.aha.core.service;

import java.util.List;

import com.aha.core.domain.Product;
import com.aha.web.dto.RefinerDto;

public interface ProductService {

	Product findByPid(String pid);

	public List<Product> findByCategoryIds(List<Long> categoryId, Integer page);

	public List<RefinerDto> getAllRefinersByCategory(List<Long> categoryId,
			Integer page);
}
