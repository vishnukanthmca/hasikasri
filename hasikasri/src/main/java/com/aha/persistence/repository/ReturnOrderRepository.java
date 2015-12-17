package com.aha.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.ReturnOrder;

@Repository
public interface ReturnOrderRepository extends JpaRepository<ReturnOrder, Long> {

}
