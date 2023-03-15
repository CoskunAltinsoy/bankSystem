package com.example.banksystem.service;

import com.example.banksystem.dto.request.CreateDistrictRequest;
import com.example.banksystem.dto.response.CityDto;
import com.example.banksystem.dto.response.DistrictDto;

public interface DistrictService {
    public void createDistrict(CreateDistrictRequest createDistrictRequest);
    public DistrictDto getCityById(Long id);
}
