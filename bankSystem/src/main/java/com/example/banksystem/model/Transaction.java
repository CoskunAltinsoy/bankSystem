package com.example.banksystem.model;

import com.example.banksystem.model.enums.TransactionStatus;
import com.example.banksystem.model.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction extends  BaseEntity {

    @Column(name = "transaction_type")
    private TransactionType transactionType;
    @Column(name = "transaction_status")
    private TransactionStatus transactionStatus;
    @Column(name = "amounts")
    private BigDecimal amount;
    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
}
