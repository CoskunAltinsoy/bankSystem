package com.example.banksystem.dto.response;

import com.example.banksystem.dto.CustomerDto;
import com.example.banksystem.model.Customer;
import com.example.banksystem.model.enums.AccountStatus;
import com.example.banksystem.model.enums.AccountType;
import com.example.banksystem.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    private String accountNumber;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private Currency currency;
    private CustomerResponse customer;
    private String customerName;
}
