package com.example.banksystem.security;

import com.example.banksystem.model.Customer;
import com.example.banksystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private CustomerRepository customerRepository;
    @Autowired
    public CustomUserDetailService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = this.customerRepository.findCustomerByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email " + email));
        return CustomUserDetail.build(customer);
    }
}
