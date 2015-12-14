package com.aha.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.Product;
import com.aha.core.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

	public List<Review> findByProduct(Product product);
}
