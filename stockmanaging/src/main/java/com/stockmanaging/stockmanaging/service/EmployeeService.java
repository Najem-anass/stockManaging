package com.stockmanaging.stockmanaging.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanaging.stockmanaging.exception.ResourceNotFoundException;
import com.stockmanaging.stockmanaging.models.Employee;
import com.stockmanaging.stockmanaging.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		if(employees.isEmpty()) {
			throw new ResourceNotFoundException("cant find any employee");
		}
		return employees;
	}

	public Optional<Employee> getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isEmpty()) {
			throw new ResourceNotFoundException("no employee found with that id");
		}
		return employee;
	}

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void updateEmployee(Long id, Employee employeeFromView) {
		
		Employee employeeFoundInDB = employeeRepository.findById(id).get();
		
		employeeFoundInDB.setMail(employeeFromView.getMail());
		employeeFoundInDB.setName(employeeFromView.getName());
		employeeFoundInDB.setPhone(employeeFromView.getPhone());
		employeeFoundInDB.setPicture(employeeFromView.getPicture());
		
		employeeRepository.save(employeeFoundInDB);
	}
	
}
