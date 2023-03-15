package com.example.banksystem.dto.converter;

import com.example.banksystem.dto.response.AddressDto;
import com.example.banksystem.dto.response.RoleDto;
import com.example.banksystem.model.Address;
import com.example.banksystem.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressConverter {
    public AddressDto convertToDto(Address address){
        return new AddressDto(
                address.getDescription()
        );
    }
    public List<AddressDto> convertToDtoList(List<Address> addresses){
        return addresses.stream().map(from -> convertToDto(from)).collect(Collectors.toList());
    }
}