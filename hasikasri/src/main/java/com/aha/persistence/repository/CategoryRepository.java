package com.aha.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	public List<Category> findAll();
	
	@Query("select c from Category c join fetch c.products where active = :active")
	public List<Category> findByActive(Boolean active);
	
}
