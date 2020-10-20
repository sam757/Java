package com.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.dto.AddressDTO;
import com.example.service.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

	@Mapping(source = "address.streetNum", target = "streetNumber") // map difference field names
	AddressDTO toDTO(Address address);
	
	@Mapping(source = "addressDTO.streetNumber", target = "streetNum")
	Address toDAO(AddressDTO addressDTO);
}
