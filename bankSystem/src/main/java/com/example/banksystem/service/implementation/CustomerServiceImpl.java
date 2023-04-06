package com.example.banksystem.service.implementation;

import com.example.banksystem.converter.CustomerConverter;
import com.example.banksystem.dto.request.AuthRequest;
import com.example.banksystem.dto.request.CreateCustomerRequest;
import com.example.banksystem.dto.response.AuthResponse;
import com.example.banksystem.dto.response.CustomerDto;
import com.example.banksystem.model.Customer;
import com.example.banksystem.repository.CustomerRepository;
import com.example.banksystem.security.CustomUserDetail;
import com.example.banksystem.security.JwtUtils;
import com.example.banksystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final CustomerConverter customerConverter;

    @Autowired
    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            JwtUtils jwtUtils,
            CustomerConverter customerConverter
    ) {
        this.customerRepository = customerRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.customerConverter = customerConverter;
    }


    @Override
    public AuthResponse login(AuthRequest authRequest) {
        Authentication authentication =
                authenticationManager.authenticate
                        (new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();

        List<String> roles = customUserDetail.getAuthorities()
                .stream().map(x -> x.getAuthority()).collect(Collectors.toList());


        return new AuthResponse(jwt);
    }

    @Override
    public CustomerDto register(CreateCustomerRequest createCustomerRequest) {

        Customer customer =
                customerConverter.convertToEntity(createCustomerRequest);

        customer.setPassword(passwordEncoder.encode(createCustomerRequest.getPassword()));

        customerRepository.save(customer);

        return customerConverter.convertToDto(customer);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        if (customer.isDeleted()){
            return null;
        }
        return customerConverter.convertToDto(customer);
    }
}
