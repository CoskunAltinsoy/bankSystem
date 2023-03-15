package com.example.banksystem.dto.converter;

import com.example.banksystem.dto.request.CreateCustomerRequest;
import com.example.banksystem.dto.response.CustomerDto;
import com.example.banksystem.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerConverter {

    public CustomerDto convertToDto(Customer customer){
        return new CustomerDto(
                customer.getEmail(),
                customer.getPassword(),
                customer.getPhoneNumber(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getNationalIdentity(),
                customer.getDateOfBirth()
        );
    }

    public List<CustomerDto> convertToListDto(List<Customer> customers){
        return customers.stream().map(from -> convertToDto(from)).collect(Collectors.toList());
    }
}
