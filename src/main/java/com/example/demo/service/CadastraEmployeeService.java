package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Employee;

public interface CadastraEmployeeService {

	Employee save(Employee employee);

	Optional<Employee> getById(Long id, Long nome);
}