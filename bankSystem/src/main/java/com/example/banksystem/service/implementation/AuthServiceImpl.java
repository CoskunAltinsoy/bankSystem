package com.example.banksystem.service.implementation;

import com.example.banksystem.dto.request.AuthRequest;
import com.example.banksystem.dto.request.CreateCustomerRequest;
import com.example.banksystem.dto.response.AuthResponse;
import com.example.banksystem.dto.response.CustomerDto;
import com.example.banksystem.repository.CustomerRepository;
import com.example.banksystem.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

   // private final CustomerRepository customerRepository;


    @Override
    public AuthResponse login(AuthRequest authRequest) {
        return null;
    }

    @Override
    public CustomerDto register(CreateCustomerRequest createCustomerRequest) {
        return null;
    }
}
