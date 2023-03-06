package com.example.banksystem.model;

import com.example.banksystem.model.enums.CardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class Card extends BaseEntity{
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "boundary")
    private BigDecimal boundary;
    @Column(name = "dept")
    private BigDecimal dept;
    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardType cardType;
    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
}
