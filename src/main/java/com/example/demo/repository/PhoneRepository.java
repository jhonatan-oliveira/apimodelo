package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Phone;

public interface PhoneRepository extends CrudRepository<Phone, String> {

}
