package com.aha.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	public Product findByPid(String pid);

	@Query("select ")
	public List<Product> findByCategoryId(Long categoryId);
}
