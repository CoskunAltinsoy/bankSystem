package com.example.banksystem.service;

import com.example.banksystem.dto.request.create.*;
import com.example.banksystem.dto.response.*;

import java.util.List;

public interface CustomerService {

    public AuthResponse login(AuthRequest authRequest);
    public CustomerResponse register(CreateCustomerRequest createCustomerRequest);
    public CustomerResponse getById(Long id);
    public List<CustomerResponse> getAll();
    public void delete(Long id);
    public PasswordResponse changePassword(CreatePasswordRequest createPasswordRequest);
    public ResetPasswordResponse resetPassword(String token, CreateTokenPasswordRequest createTokenPasswordRequest);
    public TokenResetResponse forgotPassword(CreateResetPasswordRequest createResetPasswordRequest);
}
