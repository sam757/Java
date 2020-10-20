package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.service.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

  List<Account> findByNameStartingWith(String name);

  Account findById(long id);
  
  List<Account> findByBalanceBetween(int low, int high);
}

