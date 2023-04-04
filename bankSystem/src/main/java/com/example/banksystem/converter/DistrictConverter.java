package com.example.banksystem.converter;

import com.example.banksystem.dto.request.CreateDistrictRequest;
import com.example.banksystem.dto.response.DistrictDto;
import com.example.banksystem.model.City;
import com.example.banksystem.model.District;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DistrictConverter {
    public DistrictDto convertToDto(District district){
        return new DistrictDto(
                district.getDistrictName()
        );
    }

    public District convertToEntity(CreateDistrictRequest createDistrictRequest){
        District district = new District();
        City city = new City();

        city.setId(createDistrictRequest.getCityId());

        district.setDistrictName(createDistrictRequest.getDistrictName());
        district.setCity(city);

        return district;
    }

    public List<DistrictDto> convertToDtoList(List<District> districts){
        return districts.stream().map(from -> convertToDto(from)).collect(Collectors.toList());
    }
}
