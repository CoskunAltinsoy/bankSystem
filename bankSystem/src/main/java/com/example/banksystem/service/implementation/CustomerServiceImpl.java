package com.example.banksystem.service.implementation;

import com.example.banksystem.dto.converter.AddressConverter;
import com.example.banksystem.dto.converter.CustomerConverter;
import com.example.banksystem.dto.converter.RoleConverter;
import com.example.banksystem.dto.request.AuthRequest;
import com.example.banksystem.dto.request.CreateCustomerRequest;
import com.example.banksystem.dto.response.AuthResponse;
import com.example.banksystem.dto.response.CustomerDto;
import com.example.banksystem.model.Account;
import com.example.banksystem.model.Address;
import com.example.banksystem.model.Customer;
import com.example.banksystem.model.Role;
import com.example.banksystem.repository.CustomerRepository;
import com.example.banksystem.security.JwtUtils;
import com.example.banksystem.service.AddressService;
import com.example.banksystem.service.CustomerService;
import com.example.banksystem.service.RoleService;
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
    private final CustomerConverter customerConverter;
    private final RoleService roleService;
    private final RoleConverter roleConverter;
    private final AddressConverter addressConverter;
    private final AddressService addressService;

    @Autowired
    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            JwtUtils jwtUtils,
            CustomerConverter customerConverter,
            RoleService roleService,
            RoleConverter roleConverter,
            AddressConverter addressConverter,
            AddressService addressService) {
        this.customerRepository = customerRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.customerConverter = customerConverter;
        this.roleService = roleService;
        this.roleConverter = roleConverter;
        this.addressConverter = addressConverter;
        this.addressService = addressService;
    }


    @Override
    public AuthResponse login(AuthRequest authRequest) {
        return null;
    }

    @Override
    public CustomerDto register(CreateCustomerRequest createCustomerRequest) {
        Role role = roleConverter.convertToEntity
                (roleService.getRoleById(createCustomerRequest.getRoleId()));

        Address address = addressConverter.convertToEntity
                (addressService.getAddressById(createCustomerRequest.getAddressId()));

        Customer customer =
                new Customer(
                        createCustomerRequest.getEmail(),
                        createCustomerRequest.getPassword(),
                        createCustomerRequest.getPhoneNumber(),
                        createCustomerRequest.getFirstName(),
                        createCustomerRequest.getLastName(),
                        createCustomerRequest.getNationalIdentity(),
                        createCustomerRequest.getDateOfBirth(),
                        role,
                        address
                );
        return null;
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return customerConverter.convertToDto(customer);
    }
}
