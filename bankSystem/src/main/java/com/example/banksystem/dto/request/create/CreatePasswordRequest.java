package com.example.banksystem.dto.request.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePasswordRequest {
    private String email;
    private String oldPassword;
    private String newPassword;
}
