package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Phone;

public interface CadastraPhoneService {
	
	Phone save(Phone phone);

	Optional<Phone> getById(String id);
}