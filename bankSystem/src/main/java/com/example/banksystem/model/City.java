package com.example.banksystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City extends BaseEntity{
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(mappedBy = "city")
    private Set<District> districts;
    @OneToMany(mappedBy = "city")
    private Set<Address> addresses;


}
