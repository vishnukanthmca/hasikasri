package com.aha.core.service;

import java.util.List;

import com.aha.core.domain.Product;
import com.aha.web.dto.response.RefinerDto;

public interface ProductService {

	Product findByPid(String pid);

	public List<Product> findByCategoryIds(List<Long> categoryId,
			List<Long> attributeIds, Integer page);

	public List<RefinerDto> getAllRefinersByCategory(List<Long> categoryId,
			List<Long> attributeIds, Integer page);
}
