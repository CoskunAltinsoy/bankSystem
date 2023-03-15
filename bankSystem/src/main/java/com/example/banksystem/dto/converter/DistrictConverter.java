package com.example.banksystem.dto.converter;

import com.example.banksystem.dto.response.DistrictDto;
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

    public List<DistrictDto> convertToDtoList(List<District> districts){
        return districts.stream().map(from -> convertToDto(from)).collect(Collectors.toList());
    }
}
