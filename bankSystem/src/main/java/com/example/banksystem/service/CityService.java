package com.example.banksystem.service;

import com.example.banksystem.dto.request.CreateCityRequest;
import com.example.banksystem.dto.response.CityDto;

public interface CityService {
    public void createCity(CreateCityRequest createCityRequest);
    public CityDto getCityById(Long id);
}
