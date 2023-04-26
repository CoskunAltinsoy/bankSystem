package com.example.banksystem.dto;

import com.example.banksystem.dto.response.CustomerResponse;
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
public class AccountDto {
    private String accountNumber;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private Currency currency;
    private CustomerDto customerDto;
}
