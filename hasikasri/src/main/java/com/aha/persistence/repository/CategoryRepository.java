package com.aha.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("select c from Category c left join fetch c.products where c.id = :id AND c.active = :active order by c.parentCategory.id asc")
	public Category findByActive(@Param("active") Boolean active,
			@Param("id") Long id);
}
