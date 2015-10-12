package com.aha.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.Refiner;

@Repository
public interface RefinerRepository extends JpaRepository<Refiner, Long> {

}
