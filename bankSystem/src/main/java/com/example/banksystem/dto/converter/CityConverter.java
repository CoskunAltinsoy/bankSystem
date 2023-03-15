package com.example.banksystem.dto.converter;

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
    public List<CityDto> convertToDtoList(List<City> cities){
        return cities.stream().map(from -> convertToDto(from)).collect(Collectors.toList());
    }

    public City convertToEntity(CityDto cityDto){
        return new City(
                cityDto.getCityName()
        );
    }
}
