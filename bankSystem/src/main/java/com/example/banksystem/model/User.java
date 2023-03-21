package com.example.banksystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User extends BaseEntity  {
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "is_number")
    private boolean isBlocked;

    public User(
            LocalDate createdDate,
            LocalDate updatedDate, boolean isDeleted,
            String email, String password,
            String phoneNumber,  boolean isBlocked
    ) {
        super(createdDate, updatedDate, isDeleted);
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isBlocked = isBlocked;
    }


}
