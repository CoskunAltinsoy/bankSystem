package com.example.banksystem.controller;

import com.example.banksystem.dto.request.CreateAddressRequest;
import com.example.banksystem.dto.response.AddressDto;
import com.example.banksystem.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/addresses")
public class AddressesController {
    private final AddressService addressService;
    public AddressesController(AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping
    public ResponseEntity<Void> createAddress(CreateAddressRequest createAddressRequest){
        addressService.createAddress(createAddressRequest);
        return (ResponseEntity<Void>) ResponseEntity.ok();
    }

    @GetMapping("{id}")
    public ResponseEntity<AddressDto> getByAddressId(@PathVariable("id") Long id){
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

}
