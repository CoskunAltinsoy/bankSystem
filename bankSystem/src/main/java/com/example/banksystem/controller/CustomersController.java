package com.example.banksystem.controller;

import com.example.banksystem.dto.request.AuthRequest;
import com.example.banksystem.dto.request.CreateCustomerRequest;
import com.example.banksystem.dto.response.AuthResponse;
import com.example.banksystem.dto.response.CustomerDto;
import com.example.banksystem.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(customerService.login(authRequest));
    }
    @PostMapping("register")
    public ResponseEntity<CustomerDto> register(@RequestBody CreateCustomerRequest createCustomerRequest){
        return ResponseEntity.ok(customerService.register(createCustomerRequest));
    }
    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getByCustomerById(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }


}
