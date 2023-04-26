package com.example.banksystem.dto;

import com.example.banksystem.model.enums.CardType;
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
public class CardDto {
    private BigDecimal balance;
    private String cardNumber;
    private BigDecimal boundary;
    private BigDecimal dept;
    private CardType cardType;
    private LocalDate paymentDate;
    private AccountDto accountDto;
}
