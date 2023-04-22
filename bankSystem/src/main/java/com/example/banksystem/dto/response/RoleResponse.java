package com.example.banksystem.dto.response;

import com.example.banksystem.model.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {
    private RoleType roleName;
}
