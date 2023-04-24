package com.example.banksystem.controller;

import com.example.banksystem.dto.request.create.*;
import com.example.banksystem.dto.response.*;
import com.example.banksystem.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/changePassword")
    public ResponseEntity<PasswordResponse> changePassword(
            @RequestBody CreatePasswordRequest createPasswordRequest){
        return ResponseEntity.ok(customerService.changePassword(createPasswordRequest));
    }
    @PostMapping("/forgotPassword")
    public ResponseEntity<TokenResetResponse> forgotPassword(
            @RequestBody CreateResetPasswordRequest createResetPasswordRequest){
        return ResponseEntity.ok(customerService.forgotPassword(createResetPasswordRequest));
    } @PutMapping("/resetPassword")
    public ResponseEntity<ResetPasswordResponse> resetPassword(@RequestParam String token,
            @RequestBody CreateTokenPasswordRequest createTokenPasswordRequest){
        return ResponseEntity.ok(customerService.resetPassword(token, createTokenPasswordRequest));
    }

}
