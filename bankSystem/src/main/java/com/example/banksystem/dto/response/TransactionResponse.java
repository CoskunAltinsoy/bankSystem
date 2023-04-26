package com.example.banksystem.dto.response;

import com.example.banksystem.model.enums.TransactionStatus;
import com.example.banksystem.model.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
    private BigDecimal amount;
    private LocalDate transactionDate;
    private String customerName;
}
