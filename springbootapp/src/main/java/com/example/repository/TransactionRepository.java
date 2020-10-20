package com.example.repository;

import java.util.List;

import javax.transaction.Transaction;

import org.springframework.data.repository.CrudRepository;

import com.example.service.Transactions;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
  Transaction findById(long id);
  List<Transaction> findByAmount(int amount);
  List<Transaction> findByDate(String date);
void save(Transactions transaction1);

}

