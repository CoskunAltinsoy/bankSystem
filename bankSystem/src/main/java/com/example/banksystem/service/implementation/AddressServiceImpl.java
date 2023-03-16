package com.example.banksystem.service.implementation;

import com.example.banksystem.dto.converter.AddressConverter;
import com.example.banksystem.dto.converter.CustomerConverter;
import com.example.banksystem.dto.request.CreateAddressRequest;
import com.example.banksystem.dto.response.AddressDto;
import com.example.banksystem.model.Address;
import com.example.banksystem.model.City;
import com.example.banksystem.model.Customer;
import com.example.banksystem.repository.AddressRepository;
import com.example.banksystem.service.AddressService;
import com.example.banksystem.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressConverter addressConverter;
    private final CustomerService customerService;
    private final CustomerConverter customerConverter;

    public AddressServiceImpl(
            AddressRepository addressRepository,
            AddressConverter addressConverter,
            CustomerService customerService,
            CustomerConverter customerConverter) {
        this.addressRepository = addressRepository;
        this.addressConverter = addressConverter;
        this.customerService = customerService;
        this.customerConverter = customerConverter;
    }
    @Override
    public void createAddress(CreateAddressRequest createAddressRequest) {
        Address address =
                new Address(createAddressRequest.getDescription(),
                        new City());
        addressRepository.save(address);
    }
    @Override
    public AddressDto getAddressById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow();
        return addressConverter.convertToDto(address);
    }

}
