package com.example.banksystem.service;

import com.example.banksystem.dto.request.create.CreateAddressRequest;
import com.example.banksystem.dto.response.AddressResponse;

public interface AddressService {
    public void createAddress(CreateAddressRequest createAddressRequest);
    public AddressResponse getAddressById(Long id);
}
