package com.example.banksystem.controller;

import com.example.banksystem.dto.request.create.AuthRequest;
import com.example.banksystem.dto.request.create.CreateCustomerRequest;
import com.example.banksystem.dto.response.AuthResponse;
import com.example.banksystem.dto.response.CustomerResponse;
import com.example.banksystem.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    private final CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(customerService.login(authRequest));
    }
    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> register(@RequestBody CreateCustomerRequest createCustomerRequest){
        return ResponseEntity.ok(customerService.register(createCustomerRequest));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.getById(id));
    }
    @GetMapping()
    public ResponseEntity<List<CustomerResponse>> getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
