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
@Table(name = "districts")
public class District extends BaseEntity{
    @Column(name = "district_name")
    private String districtName;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
