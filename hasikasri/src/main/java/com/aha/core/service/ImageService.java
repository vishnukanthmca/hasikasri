package com.aha.core.service;

import com.aha.core.domain.Image;

import java.util.List;

public interface ImageService {

	public List<Image> getImagesByProductId(Long productId);
}
