package com.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.dto.AccountDTO;
import com.example.service.Account;

@Mapper(componentModel = "spring", uses = { TransactionMapper.class })
public interface AccountMapper {

	@Mapping(source="account.transactions", target="transactionsDTO")
	AccountDTO toDTO(Account account);
	
	@Mapping(source="accountDTO.transactionsDTO", target="transactions")
	Account toDAO(AccountDTO accountDTO);
}
