package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import javax.transaction.Transaction;

import org.junit.jupiter.api.BeforeAll;

import org.mapstruct.factory.Mappers;

import com.example.dto.AccountDTO;
import com.example.dto.AddressDTO;
import com.example.dto.CustomerDTO;
import com.example.dto.TransactionDTO;
import com.example.mapper.AccountMapper;
import com.example.mapper.AddressMapper;
import com.example.mapper.CustomerMapper;
import com.example.mapper.TransactionMapper;
import com.example.service.Account;
import com.example.service.Address;
import com.example.service.Customer;
import com.example.service.Transactions;

class MappingTest {
	CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
	AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);
	AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);
	TransactionMapper transactionMapper = Mappers.getMapper(TransactionMapper.class);

	static Customer customer = new Customer("Lesego", "Nzimande");
	static Address address = new Address(11, "Ciepla 24", "Wroclaw", "Poland");
	static Account account = new Account(2104832, "Lesego", 132);
	static Transactions transaction1 = new Transactions(54, "5th October");
	static Transactions transaction2 = new Transactions(43, "8th October");
	
	static CustomerDTO customerDTOExpected = new CustomerDTO("Lesego");
	static AddressDTO addressDTOExpected = new AddressDTO(11, "Ciepla 24", "Wroclaw", "Poland");
	static AccountDTO accountDTOExpected = new AccountDTO(2104832, "Lesego", 132);
	static TransactionDTO transaction1DTOExpected = new TransactionDTO(12, "5th October");
	static TransactionDTO transaction2DTOExpected = new TransactionDTO(65, "8th October");

	@BeforeAll
	static void init() {
		customer.setAddress(address);
		account.getTransactions().add(transaction1);
		account.getTransactions().add(transaction2);
		customer.getAccounts().add(account);
		
		customerDTOExpected.setAddressDTO(addressDTOExpected);
		accountDTOExpected.getTransactionsDTO().add(transaction1DTOExpected);
		accountDTOExpected.getTransactionsDTO().add(transaction2DTOExpected);
		customerDTOExpected.getAccountsDTO().add(accountDTOExpected);	
		
		
	}
	@Test
	void addressMapperTest() {
		AddressDTO addressDTOActual = addressMapper.toDTO(address);
		assertThat(addressDTOActual).usingRecursiveComparison().isEqualTo(addressDTOExpected);
	}

	@Test
	void customerMapperTest() {
		CustomerDTO customerDTOActual = customerMapper.toDTO(customer);
		assertThat(customerDTOActual).usingRecursiveComparison().isEqualTo(customerDTOExpected);
	}
	
	@Test
	void accountMapperTest() {
		AccountDTO accountDTOActual = accountMapper.toDTO(account);
		assertThat(accountDTOActual).usingRecursiveComparison().isEqualTo(accountDTOExpected);
	}

	@Test
	void transactionMapperTest() {
		TransactionDTO transaction1DTOActual = transactionMapper.toDTO(transaction1);
		assertThat(transaction1DTOActual).usingRecursiveComparison().isEqualTo(transaction1DTOExpected);
	}
}

