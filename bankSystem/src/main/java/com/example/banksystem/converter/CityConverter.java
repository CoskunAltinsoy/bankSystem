package com.example.banksystem.converter;

import com.example.banksystem.dto.request.CreateCityRequest;
import com.example.banksystem.dto.response.CityDto;
import com.example.banksystem.dto.response.DistrictDto;
import com.example.banksystem.model.City;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityConverter {
    public CityDto convertToDto(City city){
        return new CityDto(
                city.getCityName()
        );
    }
    public City convertToEntity(CreateCityRequest createCityRequest){
        City city = new City();

        city.setCityName(createCityRequest.getCityName());

        return city;
    }
    public List<CityDto> convertToDtoList(List<City> cities){
        return cities.stream().map(from -> convertToDto(from)).collect(Collectors.toList());
    }


}
