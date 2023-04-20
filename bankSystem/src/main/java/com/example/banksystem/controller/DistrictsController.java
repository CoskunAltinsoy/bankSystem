package com.example.banksystem.controller;

import com.example.banksystem.dto.request.AuthRequest;
import com.example.banksystem.dto.request.CreateDistrictRequest;
import com.example.banksystem.dto.response.AuthResponse;
import com.example.banksystem.dto.response.DistrictDto;
import com.example.banksystem.service.DistrictService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/districts")

public class DistrictsController {
    private final DistrictService districtService;
    public DistrictsController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PostMapping
    public ResponseEntity<Void> createDistrict(@RequestBody CreateDistrictRequest createDistrictRequest){
        districtService.createDistrict(createDistrictRequest);
        return (ResponseEntity<Void>) ResponseEntity.ok();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistrictDto> getByDistrictId(@PathVariable("id") Long id){
        return ResponseEntity.ok(districtService.getCityById(id));
    }
}
