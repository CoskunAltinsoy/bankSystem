package com.example.banksystem.service.implementation;

import com.example.banksystem.dto.converter.AddressConverter;
import com.example.banksystem.dto.request.CreateAddressRequest;
import com.example.banksystem.dto.response.AddressDto;
import com.example.banksystem.model.Address;
import com.example.banksystem.repository.AddressRepository;
import com.example.banksystem.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressConverter addressConverter;

    public AddressServiceImpl(
            AddressRepository addressRepository,
            AddressConverter addressConverter) {
        this.addressRepository = addressRepository;
        this.addressConverter = addressConverter;
    }
    @Override
    public void createAddress(CreateAddressRequest createAddressRequest) {
        Address address = new Add
    }
    @Override
    public AddressDto getAddressById(Long id) {
        return null;
    }
}
