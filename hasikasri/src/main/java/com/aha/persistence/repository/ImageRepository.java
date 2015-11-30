package com.aha.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

	@Query("select i from Image i where i.product.id = :productId")
	public List<Image> getImagesByProductId(@Param("productId") Long productId);
}
