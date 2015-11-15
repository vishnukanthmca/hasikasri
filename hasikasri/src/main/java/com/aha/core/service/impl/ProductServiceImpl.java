package com.aha.core.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aha.core.domain.Product;
import com.aha.core.domain.Attribute;
import com.aha.core.service.ProductService;
import com.aha.persistence.repository.ProductRepository;
import com.aha.web.dto.AttributeDto;
import com.aha.web.dto.RefinerDto;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Integer NO_OF_PRODUCTS_PER_PAGE = 9;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product findByPid(String pid) {
		return productRepository.findByPid(pid);
	}

	public List<Product> findByCategoryIds(List<Long> categoryIds, Integer page) {

		PageRequest pageRequest = new PageRequest(page,
				NO_OF_PRODUCTS_PER_PAGE, Sort.Direction.DESC, "id");

		return productRepository.findByCategoryIds(categoryIds, pageRequest);
	}

	@Override
	public List<RefinerDto> getAllRefinersByCategory(List<Long> categoryIds,
			Integer page) {

		PageRequest pageRequest = new PageRequest(page,
				NO_OF_PRODUCTS_PER_PAGE, Sort.Direction.DESC, "id");

		List<Product> list = productRepository.getAllRefinersByCategory(
				categoryIds, pageRequest);

		Set<String> uniqueRefiners = new HashSet<>();
		Set<String> uniqueValues = new HashSet<>();

		List<RefinerDto> dtos = new ArrayList<RefinerDto>();

		if (list != null && !list.isEmpty()) {
			list.forEach(product -> {

				List<Attribute> attributes = product.getAttributes();

				if (attributes != null && !attributes.isEmpty()) {
					attributes.forEach(attrib -> {

						AttributeDto attributeDto = new AttributeDto();
						attributeDto.setId(attrib.getId());
						attributeDto.setValue(attrib.getValue());

						RefinerDto refinerDto = new RefinerDto();
						refinerDto.setName(attrib.getRefiner());

						if (uniqueRefiners.add(attrib.getRefiner())) {

							if (uniqueValues.add(attrib.getValue())) {

								List<AttributeDto> attributeDtos = new ArrayList<>();
								attributeDtos.add(attributeDto);

								refinerDto.setAttributes(attributeDtos);
							}

							dtos.add(refinerDto);

						} else {

							if (uniqueValues.add(attrib.getValue())) {

								RefinerDto saved = dtos.get(dtos
										.indexOf(refinerDto));
								if (saved != null
										&& saved.getAttributes() != null) {
									saved.getAttributes().add(attributeDto);
								}
							}
						}
					});
				}
			});
		}
		return dtos;
	}
}