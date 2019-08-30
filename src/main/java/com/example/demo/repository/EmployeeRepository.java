package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeId;

public interface EmployeeRepository extends JpaRepository<Employee, EmployeeId> {

}
