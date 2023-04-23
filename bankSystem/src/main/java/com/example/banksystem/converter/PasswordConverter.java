package com.example.banksystem.converter;

import com.example.banksystem.dto.request.create.CreatePasswordRequest;
import com.example.banksystem.dto.response.PasswordResponse;
import org.springframework.stereotype.Component;

@Component
public class PasswordConverter {
    public PasswordResponse convertToResponse(CreatePasswordRequest createPasswordRequest){
        PasswordResponse passwordResponse = new PasswordResponse();

        passwordResponse.setEmail(createPasswordRequest.getEmail());
        passwordResponse.setOldPassword(createPasswordRequest.getOldPassword());
        passwordResponse.setNewPassword(createPasswordRequest.getNewPassword());

        return passwordResponse;
    }
}
