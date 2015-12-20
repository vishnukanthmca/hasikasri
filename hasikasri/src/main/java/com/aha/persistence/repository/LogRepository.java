package com.aha.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
