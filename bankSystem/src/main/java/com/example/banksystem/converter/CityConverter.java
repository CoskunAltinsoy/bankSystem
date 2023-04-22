package com.example.banksystem.converter;

import com.example.banksystem.dto.request.create.CreateCityRequest;
import com.example.banksystem.dto.response.CityResponse;
import com.example.banksystem.model.City;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityConverter {
    public CityResponse convertToDto(City city){
        CityResponse cityResponse = new CityResponse();

        cityResponse.setCityName(city.getCityName());

        return cityResponse;
    }
    public City convertToEntity(CreateCityRequest createCityRequest){
        City city = new City();

        city.setCityName(createCityRequest.getCityName());

        return city;
    }
    public List<CityResponse> convertToDtoList(List<City> cities){
        return cities.stream().map(from -> convertToDto(from)).collect(Collectors.toList());
    }
}
