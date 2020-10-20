package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.service.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
  Address findById(long id);
}

