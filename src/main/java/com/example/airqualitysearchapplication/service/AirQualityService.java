package com.example.airqualitysearchapplication.service;

import com.example.airqualitysearchapplication.dto.AirQualityDto;
import com.example.airqualitysearchapplication.dto.CitySearchResponseDto;

import java.util.List;

public interface AirQualityService {

    List<CitySearchResponseDto> searchCity(String city);

    AirQualityDto getAirQualityByCityId(String cityId);
}
