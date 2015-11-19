package com.aha.core.service;

import java.util.List;

import com.aha.core.domain.Product;
import com.aha.web.dto.response.FilterDto;

public interface ProductService {

	Product findByPid(String pid);

	public List<Product> findByCategoryIds(List<Long> categoryId,
			List<Long> attributeIds, Integer page);

	public FilterDto getAllRefinersByCategory(List<Long> categoryId,
			List<Long> attributeIds, Integer page);
}
