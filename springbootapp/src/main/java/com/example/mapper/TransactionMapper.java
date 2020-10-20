package com.example.mapper;

import javax.transaction.Transaction;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.dto.TransactionDTO;
import com.example.service.Transactions;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
	TransactionDTO toDTO(Transactions transaction1);
	Transaction toDAO(TransactionDTO transactionDTO);
}
