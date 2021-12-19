package com.stockmanaging.stockmanaging.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanaging.stockmanaging.models.Company;
import com.stockmanaging.stockmanaging.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/all")
	public List<Company> getAllCompanies(){
		List<Company> companies = companyService.getAllCompanies();
		return companies;
	}
	
	@GetMapping("/{id}")
	public Optional<Company> getCompanyById(@PathVariable("id") Long id) {
		Optional<Company> company = companyService.getCompanyById(id);
		return company;
	}
	
	@PostMapping("/add")
	public void addCompany(@RequestBody Company company ) {
		companyService.addCompany(company);
	}
	
}
