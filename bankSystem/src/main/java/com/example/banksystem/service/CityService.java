package com.example.banksystem.service;

import com.example.banksystem.dto.request.create.CreateCityRequest;
import com.example.banksystem.dto.response.CityResponse;

public interface CityService {
    public void createCity(CreateCityRequest createCityRequest);
    public CityResponse getCityById(Long id);
}
