package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Phone;
import com.example.demo.repository.PhoneRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("v1/phone")
public class CadastraPhoneServiceImpl implements CadastraPhoneService {

	@Autowired
	private PhoneRepository phoneRepository;

	@Override
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Phone> getById(@PathVariable String id) {
		Optional<Phone> phone = phoneRepository.findById(id);
		if (!phone.isPresent()) {
			throw new RuntimeException("Telefone nao encontrado!");
		}
		return phone;
	}

	@Override
	@ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
	public Phone save(Phone phone) {
		return phoneRepository.save(phone);
	}
}