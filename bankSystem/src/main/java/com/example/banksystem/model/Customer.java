package com.example.banksystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="individual_customers")
@PrimaryKeyJoinColumn(name="customer_id")
public class Customer extends User {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "national_identity")
    private String nationalIdentity;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Account> accounts;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Customer(
            String email, String password,
            String phoneNumber, String firstName,
            String lastName, String nationalIdentity,
            LocalDate dateOfBirth, Role role,
            Set<Account> accounts, Address address
    ) {
        super(email, password, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalIdentity = nationalIdentity;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.accounts = accounts;
        this.address = address;
    }

    public Customer(
            String email, String password,
            String phoneNumber, String firstName,
            String lastName, String nationalIdentity,
            LocalDate dateOfBirth, Role role,
            Address address
    ) {
        super(email, password, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalIdentity = nationalIdentity;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.address = address;
    }

    public Customer(
            String email, String password,
            String phoneNumber, String firstName,
            String lastName, String nationalIdentity,
            LocalDate dateOfBirth) {
        super(email, password, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalIdentity = nationalIdentity;
        this.dateOfBirth = dateOfBirth;
    }
    
}
