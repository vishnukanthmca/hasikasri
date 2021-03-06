package com.aha.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.Image;
import com.aha.core.service.ImageService;
import com.aha.persistence.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public List<Image> getImagesByProductId(Long productId) {
		return imageRepository.getImagesByProductId(productId);
	}

}
