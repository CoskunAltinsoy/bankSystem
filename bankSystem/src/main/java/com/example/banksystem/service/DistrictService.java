package com.example.banksystem.service;

import com.example.banksystem.dto.request.create.CreateDistrictRequest;
import com.example.banksystem.dto.response.DistrictResponse;

public interface DistrictService {
    public void createDistrict(CreateDistrictRequest createDistrictRequest);
    public DistrictResponse getCityById(Long id);
}
