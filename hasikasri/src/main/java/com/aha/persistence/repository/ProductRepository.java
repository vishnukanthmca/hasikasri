package com.aha.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	public Product findByPid(String pid);

	@Query("select p from Product p where  p.category.id in :categoryIds")
	public List<Product> findByCategoryIds(
			@Param("categoryIds") List<Long> categoryIds, Pageable pageable);
}
