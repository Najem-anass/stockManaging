package com.stockmanaging.stockmanaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanaging.stockmanaging.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
