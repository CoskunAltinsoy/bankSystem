package com.example.banksystem.converter;

import com.example.banksystem.dto.request.create.CreateTokenPasswordRequest;
import com.example.banksystem.dto.response.ResetPasswordResponse;
import org.springframework.stereotype.Component;

@Component
public class ResetTokenConverter {
    public ResetPasswordResponse convertToResponse(CreateTokenPasswordRequest createTokenPasswordRequest){
        ResetPasswordResponse resetPasswordResponse = new ResetPasswordResponse();

        resetPasswordResponse.setPassword(createTokenPasswordRequest.getPassword());

        return resetPasswordResponse;
    }
}
