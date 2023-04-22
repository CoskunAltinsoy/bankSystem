package com.example.banksystem.service;

import com.example.banksystem.dto.request.create.AuthRequest;
import com.example.banksystem.dto.request.create.CreateCustomerRequest;
import com.example.banksystem.dto.response.AuthResponse;
import com.example.banksystem.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    public AuthResponse login(AuthRequest authRequest);
    public CustomerResponse register(CreateCustomerRequest createCustomerRequest);
    public CustomerResponse getById(Long id);
    public List<CustomerResponse> getAll();
    public void delete(Long id);
}
