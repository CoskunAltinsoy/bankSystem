package com.example.banksystem.converter;

import com.example.banksystem.dto.request.create.CreateDistrictRequest;
import com.example.banksystem.dto.response.DistrictResponse;
import com.example.banksystem.model.City;
import com.example.banksystem.model.District;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DistrictConverter {
    public DistrictResponse convertToDto(District district){
        DistrictResponse districtResponse = new DistrictResponse();

        districtResponse.setDistrictName(district.getDistrictName());

        return districtResponse;
    }

    public District convertToEntity(CreateDistrictRequest createDistrictRequest){
        District district = new District();
        City city = new City();

        city.setId(createDistrictRequest.getCityId());

        district.setDistrictName(createDistrictRequest.getDistrictName());
        district.setCity(city);

        return district;
    }

    public List<DistrictResponse> convertToDtoList(List<District> districts){
        return districts.stream().map(from -> convertToDto(from)).collect(Collectors.toList());
    }
}
