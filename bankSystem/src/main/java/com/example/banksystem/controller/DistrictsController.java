package com.example.banksystem.controller;

import com.example.banksystem.dto.request.create.CreateDistrictRequest;
import com.example.banksystem.dto.response.DistrictResponse;
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
    public ResponseEntity<DistrictResponse> getByDistrictId(@PathVariable("id") Long id){
        return ResponseEntity.ok(districtService.getCityById(id));
    }
}
