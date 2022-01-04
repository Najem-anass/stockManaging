package com.stockmanaging.stockmanaging.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanaging.stockmanaging.models.Employee;
import com.stockmanaging.stockmanaging.repository.EmployeeRepository;
import com.stockmanaging.stockmanaging.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id).get(), HttpStatus.OK);
	}
	
	@PutMapping("/add")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
		employeeService.addEmployee(employee);
		return new ResponseEntity<>("employee added successfully" , HttpStatus.OK);	
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") Long id , @RequestBody Employee employee){
		employeeService.updateEmployee(id, employee);
		return new ResponseEntity<>("employee updated successfully", HttpStatus.OK);
	}
	
	
	
}
