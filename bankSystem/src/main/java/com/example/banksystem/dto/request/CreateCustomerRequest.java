package com.example.banksystem.dto.request;

import com.example.banksystem.dto.response.AddressDto;
import com.example.banksystem.dto.response.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
    private String email;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String nationalIdentity;
    private LocalDate dateOfBirth;
    private Long roleId;
    private Long addressId;


}
