package com.example.banksystem.converter;

import com.example.banksystem.dto.request.create.CreateAddressRequest;
import com.example.banksystem.dto.response.AddressResponse;
import com.example.banksystem.model.Address;
import com.example.banksystem.model.City;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressConverter {
    public AddressResponse convertToDto(Address address){
        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setDescription(address.getDescription());

        return addressResponse;
    }
    public List<AddressResponse> convertToDtoList(List<Address> addresses){
        return addresses.stream().map(from -> convertToDto(from)).collect(Collectors.toList());
    }

    public Address convertToEntity(CreateAddressRequest createAddressRequest){
        Address address = new Address();
        City city = new City();

        city.setId(createAddressRequest.getCityId());

        address.setDescription(createAddressRequest.getDescription());
        address.setCity(city);

        return address;
    }
}
