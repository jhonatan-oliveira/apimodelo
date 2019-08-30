package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeId;
import com.example.demo.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("v1/employee")
public class CadastraEmployeeServiceImpl implements CadastraEmployeeService {

	@Autowired
	private EmployeeRepository EmployeeRepository;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "buscaFuncionario/{idCompany}/{idEmployee}", method = RequestMethod.GET)
	public Optional<Employee> getById(@PathVariable Long idCompany, @PathVariable Long idEmployee) {
		Optional<Employee> employee = EmployeeRepository.findById(new EmployeeId(idCompany, idEmployee));
		if (!employee.isPresent()) {
			throw new RuntimeException("Telefone nao encontrado!");
		}
		return employee;
	}

	@Override
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public Employee save(@RequestBody Employee Employee) {
		return EmployeeRepository.save(Employee);
	}
}