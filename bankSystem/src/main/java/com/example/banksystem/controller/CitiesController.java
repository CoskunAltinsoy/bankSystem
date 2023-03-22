package com.example.banksystem.controller;

import com.example.banksystem.dto.request.CreateCityRequest;
import com.example.banksystem.dto.response.CityDto;
import com.example.banksystem.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cities")
public class CitiesController {
    private final CityService cityService;
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }
    @PostMapping
    public ResponseEntity<Void> createCity(@RequestBody CreateCityRequest createCityRequest){
        cityService.createCity(createCityRequest);
        return (ResponseEntity<Void>)ResponseEntity.ok();
    }
    @GetMapping({"id"})
    public ResponseEntity<CityDto> getByCityId(@PathVariable("id") Long id){
        return ResponseEntity.ok(cityService.getCityById(id));
    }
}
