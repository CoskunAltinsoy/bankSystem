package com.example.banksystem.service.implementation;


import com.example.banksystem.converter.CityConverter;
import com.example.banksystem.converter.DistrictConverter;
import com.example.banksystem.dto.request.CreateDistrictRequest;
import com.example.banksystem.dto.response.DistrictDto;
import com.example.banksystem.model.City;
import com.example.banksystem.model.District;
import com.example.banksystem.repository.DistrictRepository;
import com.example.banksystem.service.CityService;
import com.example.banksystem.service.DistrictService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;
    private final DistrictConverter districtConverter;
    private final CityService cityService;
    private final CityConverter cityConverter;

    public DistrictServiceImpl(
            DistrictRepository districtRepository,
            DistrictConverter districtConverter,
            CityService cityService,
            CityConverter cityConverter) {
        this.districtRepository = districtRepository;
        this.districtConverter = districtConverter;
        this.cityService = cityService;
        this.cityConverter = cityConverter;
    }

    @Override
    public void createDistrict(CreateDistrictRequest createDistrictRequest) {
        District district = districtConverter.convertToEntity(createDistrictRequest);
        district.setCreatedDate(LocalDate.now());
        district.setDeleted(false);
        districtRepository.save(district);
    }
    @Override
    public DistrictDto getCityById(Long id) {
        District district = districtRepository.findById(id).orElseThrow();
        if (district.isDeleted()){
            return null;
        }
        return districtConverter.convertToDto(district);
    }

}
