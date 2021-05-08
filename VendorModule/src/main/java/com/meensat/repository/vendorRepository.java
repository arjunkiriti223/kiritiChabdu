package com.meensat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.meensat.model.Vendor;

@Repository
@EnableJpaRepositories
public interface vendorRepository extends JpaRepository<Vendor, Long> {

	Vendor findByEmail(String email);
}
