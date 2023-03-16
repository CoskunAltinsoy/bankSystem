package com.example.banksystem.service.implementation;

import com.example.banksystem.dto.converter.CityConverter;
import com.example.banksystem.dto.request.CreateCityRequest;
import com.example.banksystem.dto.response.CityDto;
import com.example.banksystem.model.City;
import com.example.banksystem.repository.CityRepository;
import com.example.banksystem.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityConverter cityConverter;
    public CityServiceImpl(CityRepository cityRepository, CityConverter cityConverter) {
        this.cityRepository = cityRepository;
        this.cityConverter = cityConverter;
    }
    @Override
    public void createCity(CreateCityRequest createCityRequest) {
        City city = new City(
                createCityRequest.getCityName()
        );
        cityRepository.save(city);
    }
    @Override
    public CityDto getCityById(Long id) {
        City city = this.cityRepository.findById(id).orElseThrow();
        return cityConverter.convertToDto(city);
    }

}
