package com.example.banksystem.service.implementation;

import com.example.banksystem.converter.AddressConverter;
import com.example.banksystem.converter.CityConverter;
import com.example.banksystem.converter.CustomerConverter;
import com.example.banksystem.dto.request.CreateAddressRequest;
import com.example.banksystem.dto.response.AddressDto;
import com.example.banksystem.model.Address;
import com.example.banksystem.model.City;
import com.example.banksystem.repository.AddressRepository;
import com.example.banksystem.service.AddressService;
import com.example.banksystem.service.CityService;
import com.example.banksystem.service.CustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressConverter addressConverter;
    private final CustomerService customerService;
    private final CustomerConverter customerConverter;
    private final CityService cityService;
    private final CityConverter cityConverter;

    public AddressServiceImpl(
            AddressRepository addressRepository,
            AddressConverter addressConverter,
            CustomerService customerService,
            CustomerConverter customerConverter,
            CityService cityService,
            CityConverter cityConverter
    ) {
        this.addressRepository = addressRepository;
        this.addressConverter = addressConverter;
        this.customerService = customerService;
        this.customerConverter = customerConverter;
        this.cityService = cityService;
        this.cityConverter = cityConverter;
    }
    @Override
    public void createAddress(CreateAddressRequest createAddressRequest) {
        Address address = addressConverter.convertToEntity(createAddressRequest);
        address.setCreatedDate(LocalDate.now());
        address.setDeleted(false);
        addressRepository.save(address);
    }
    @Override
    public AddressDto getAddressById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow();
        if (address.isDeleted()){
            return null;
        }
        return addressConverter.convertToDto(address);
    }

}
