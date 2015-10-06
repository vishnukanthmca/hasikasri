package com.aha.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	public List<Category> findAll();

	@Query("select c from Category c left join fetch c.products where c.id = :id AND c.active = :active order by c.parentCategory.id asc")
	public Category findByActive(@Param("active") Boolean active,
			@Param("id") Long id);

	@Query("select c from Category c where c.id = :id AND c.active = :active")
	public Category findAllParents(@Param("active") Boolean active,
			@Param("id") Long id);

}
