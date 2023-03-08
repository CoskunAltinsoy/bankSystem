package com.example.banksystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity{
    @Column(name = "description")
    private String description;
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Customer customer;
}
