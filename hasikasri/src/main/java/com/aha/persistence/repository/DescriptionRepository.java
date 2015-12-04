package com.aha.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.Description;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {

	@Query("select d from Description d where d.product.id = :productId")
	public List<Description> getDescriptionsByProductId(
			@Param("productId") Long productId);
}
