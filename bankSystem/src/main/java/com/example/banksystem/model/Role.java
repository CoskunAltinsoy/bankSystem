package com.example.banksystem.model;

import com.example.banksystem.model.enums.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleType roleName;

    @OneToMany(mappedBy = "role")
    private List<Customer> customers;

}
