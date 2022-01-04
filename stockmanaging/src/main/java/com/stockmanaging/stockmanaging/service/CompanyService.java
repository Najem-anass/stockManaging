package com.stockmanaging.stockmanaging.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanaging.stockmanaging.exception.ResourceNotFoundException;
import com.stockmanaging.stockmanaging.models.Company;
import com.stockmanaging.stockmanaging.repository.CompanyJPA;

@Service
public class CompanyService {

	@Autowired
	private CompanyJPA companyJPA;

	public List<Company> getAllCompanies() {
		List<Company> companies = companyJPA.findAll();
		if (companies.isEmpty()) {
			throw new ResourceNotFoundException("no company exist till now ");
		}
		return companies;
	}

	public Optional<Company> getCompanyById(Long id) {
		Optional<Company> company = companyJPA.findById(id);
		if (company.isEmpty()) {
			throw new ResourceNotFoundException("no company found with that id");
		}
		return company;
	}

	public void addCompany(Company company) {
		companyJPA.save(company);
	}

	public void updateCompany(Long id , Company companyFromView) {
		
		Company companyFoundInDB = companyJPA.findById(id).get();
		
		companyFoundInDB.setMail(companyFromView.getMail());
		companyFoundInDB.setName(companyFromView.getName());
		companyFoundInDB.setPhone(companyFromView.getPhone());
		companyFoundInDB.setPicture(companyFromView.getPicture());
		companyFoundInDB.setDescription(companyFromView.getDescription());
		
		companyJPA.save(companyFoundInDB);
	}
	
	public void deleteCompany(Long id) {
		companyJPA.deleteById(id);
	}
	
	

}
