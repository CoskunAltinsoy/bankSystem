package com.example.banksystem.service.implementation;

import com.example.banksystem.converter.CityConverter;
import com.example.banksystem.dto.request.CreateCityRequest;
import com.example.banksystem.dto.response.CityDto;
import com.example.banksystem.model.City;
import com.example.banksystem.repository.CityRepository;
import com.example.banksystem.service.CityService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
        City city = cityConverter.convertToEntity(createCityRequest);
        city.setCreatedDate(LocalDate.now());
        city.setDeleted(false);
        cityRepository.save(city);
    }
    @Override
    public CityDto getCityById(Long id) {
        City city = cityRepository.findById(id).orElseThrow();
        if(city.isDeleted()){
            return null;
        }
        return cityConverter.convertToDto(city);
    }

}
