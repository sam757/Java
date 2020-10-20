package com.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.dto.CustomerDTO;
import com.example.service.Customer;


@Mapper(componentModel = "spring", uses = { AddressMapper.class, AccountMapper.class})	
public interface CustomerMapper {
	@Mappings({
	      @Mapping(source = "customer.address", target = "addressDTO"),
	      @Mapping(source = "customer.accounts", target = "accountsDTO"),
	      @Mapping(source = "customer.firstName", target = "name")
	    })
	CustomerDTO toDTO(Customer customer);
	
	@Mappings({
	 @Mapping(source = "customerDTO.addressDTO", target = "address"),
     @Mapping(source = "customerDTO.accountsDTO", target = "accounts"),
     @Mapping(source = "customerDTO.name", target = "firstName")
    })
	Customer toDAO(CustomerDTO customerDTO);
}
