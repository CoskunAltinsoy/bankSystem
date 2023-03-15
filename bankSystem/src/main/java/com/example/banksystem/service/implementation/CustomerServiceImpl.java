package com.example.banksystem.service.implementation;

import com.example.banksystem.dto.request.AuthRequest;
import com.example.banksystem.dto.request.CreateCustomerRequest;
import com.example.banksystem.dto.response.AuthResponse;
import com.example.banksystem.dto.response.CustomerDto;
import com.example.banksystem.model.Address;
import com.example.banksystem.model.Customer;
import com.example.banksystem.repository.CustomerRepository;
import com.example.banksystem.security.JwtUtils;
import com.example.banksystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Autowired
    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            JwtUtils jwtUtils
    ) {
        this.customerRepository = customerRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }


    @Override
    public AuthResponse login(AuthRequest authRequest) {
        return null;
    }

    @Override
    public CustomerDto register(CreateCustomerRequest createCustomerRequest) {

       /* Customer customer =
                new Customer(
                        createCustomerRequest.getEmail(),
                        createCustomerRequest.getPassword(),
                        createCustomerRequest.getPhoneNumber(),
                        createCustomerRequest.getFirstName(),
                        createCustomerRequest.getLastName(),
                        createCustomerRequest.getNationalIdentity(),
                        createCustomerRequest.getDateOfBirth(),
                        createCustomerRequest.getRoleId(),
                        createCustomerRequest.getAddressId()
                );*/
        return null;
    }
}
