package com.stockmanaging.stockmanaging.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanaging.stockmanaging.models.Company;
import com.stockmanaging.stockmanaging.repository.CompanyJPA;

@Service
public class CompanyService {

	@Autowired
	private CompanyJPA companyJPA;
	
	public List<Company> getAllCompanies() {
		List<Company> companies = companyJPA.findAll();
		return companies; 
	}
	
	public Optional<Company> getCompanyById(Long id) {
		//System.out.println("service id " + id);
		Optional<Company> company = companyJPA.findById(id);
		//System.out.println("service company : " + company);
		return company;
	}
	
	public void addCompany(Company company) {
		companyJPA.save(company);
	}
	
	
	
}
