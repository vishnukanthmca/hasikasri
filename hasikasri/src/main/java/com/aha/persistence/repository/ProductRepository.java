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

	@Query("select distinct(p) from Product p where p.category.id in :categoryIds AND p.price between :minPrice AND :maxPrice")
	public List<Product> findByCategoryIds(
			@Param("categoryIds") List<Long> categoryIds,
			@Param("minPrice") Double minPrice,
			@Param("maxPrice") Double maxPrice, Pageable pageable);

	@Query("select distinct(p) from Product p join p.attributes a where p.category.id in :categoryIds AND a.id in :attributeIds AND p.price between :minPrice AND :maxPrice")
	public List<Product> findByCategoryIdsAndAttributeIdsAndPrice(
			@Param("categoryIds") List<Long> categoryIds,
			@Param("attributeIds") List<Long> attributeIds,
			@Param("minPrice") Double minPrice,
			@Param("maxPrice") Double maxPrice, Pageable pageable);

	@Query("select distinct(product) from Product product join fetch product.attributes where product.id in(select distinct(p.id) from Product p join p.attributes a where p.category.id in :categoryIds AND p.price between :minPrice AND :maxPrice)")
	public List<Product> getAllRefinersByCategory(
			@Param("categoryIds") List<Long> categoryIds,
			@Param("minPrice") Double minPrice,
			@Param("maxPrice") Double maxPrice, Pageable pageable);

	@Query("select distinct(product) from Product product join fetch product.attributes where product.id in(select distinct(p.id) from Product p join p.attributes a where p.category.id in :categoryIds AND a.id in :attributeIds AND p.price between :minPrice AND :maxPrice)")
	public List<Product> getAllRefinersByCategoryAndAttributeIdAndPrice(
			@Param("categoryIds") List<Long> categoryIds,
			@Param("attributeIds") List<Long> attributeIds,
			@Param("minPrice") Double minPrice,
			@Param("maxPrice") Double maxPrice, Pageable pageable);
}
