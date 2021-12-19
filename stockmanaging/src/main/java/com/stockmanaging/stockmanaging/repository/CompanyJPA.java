package com.stockmanaging.stockmanaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanaging.stockmanaging.models.Company;

@Repository
public interface CompanyJPA extends JpaRepository<Company, Long> {

	
	
}
