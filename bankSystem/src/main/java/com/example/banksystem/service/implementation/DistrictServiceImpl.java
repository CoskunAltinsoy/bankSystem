package com.example.banksystem.service.implementation;


import com.example.banksystem.dto.converter.CityConverter;
import com.example.banksystem.dto.converter.DistrictConverter;
import com.example.banksystem.dto.request.CreateDistrictRequest;
import com.example.banksystem.dto.response.DistrictDto;
import com.example.banksystem.model.City;
import com.example.banksystem.model.District;
import com.example.banksystem.repository.DistrictRepository;
import com.example.banksystem.service.DistrictService;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;
    private final DistrictConverter districtConverter;
    private final CityServiceImpl cityServiceImpl;
    private final CityConverter cityConverter;

    public DistrictServiceImpl(
            DistrictRepository districtRepository,
            DistrictConverter districtConverter,
            CityServiceImpl cityServiceImpl,
            CityConverter cityConverter) {
        this.districtRepository = districtRepository;
        this.districtConverter = districtConverter;
        this.cityServiceImpl = cityServiceImpl;
        this.cityConverter = cityConverter;
    }

    @Override
    public void createDistrict(CreateDistrictRequest createDistrictRequest) {
        City city =
                cityConverter.convertToEntity(cityServiceImpl.getCityById(createDistrictRequest.getCityId()));
        District district = new District(
                createDistrictRequest.getDistrictName(),
                city
        );
    }
    @Override
    public DistrictDto getCityById(Long id) {
        District district = districtRepository.findById(id).orElseThrow();
        return districtConverter.convertToDto(district);
    }
}
