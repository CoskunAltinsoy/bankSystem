package com.example.banksystem.service;

import com.example.banksystem.dto.request.AuthRequest;
import com.example.banksystem.dto.request.CreateCustomerRequest;
import com.example.banksystem.dto.response.AuthResponse;
import com.example.banksystem.dto.response.CustomerDto;
import com.example.banksystem.model.User;

public interface AuthService {

    public AuthResponse login(AuthRequest authRequest);
    public CustomerDto register(CreateCustomerRequest createCustomerRequest);

}
