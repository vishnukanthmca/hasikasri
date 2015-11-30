package com.aha.core.service;

import java.util.List;

import com.aha.core.domain.Product;
import com.aha.web.dto.request.GetProductsInputDto;
import com.aha.web.dto.response.FilterDto;

public interface ProductService {

	Product findById(Long id);

	Product findByPid(String pid);

	public List<Product> findByCategoryIds(GetProductsInputDto input,
			Integer page);

	public FilterDto getAllRefinersByCategory(GetProductsInputDto input,
			Integer page);
}
