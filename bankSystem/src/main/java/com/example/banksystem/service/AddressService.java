package com.example.banksystem.service;

import com.example.banksystem.dto.request.CreateAddressRequest;
import com.example.banksystem.dto.response.AddressDto;

public interface AddressService {
    public void createAddress(CreateAddressRequest createAddressRequest);
    public AddressDto getAddressById(Long id);
}
