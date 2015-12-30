package com.aha.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.Address;
import com.aha.core.domain.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	@Query("select a from Address a where a.user = :user order by a.updatedDate desc")
	public List<Address> findAddresses(@Param("user") User user);
}
