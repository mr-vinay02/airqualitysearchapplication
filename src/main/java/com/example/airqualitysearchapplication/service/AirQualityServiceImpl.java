package com.example.airqualitysearchapplication.service;

import com.example.airqualitysearchapplication.dto.AirQualityDto;
import com.example.airqualitysearchapplication.dto.CitySearchResponseDto;
import com.example.airqualitysearchapplication.model.AirQualityData;
import com.example.airqualitysearchapplication.service.AirQualityMapper;
import com.example.airqualitysearchapplication.service.AirQualityService;
import com.example.airqualitysearchapplication.vendor.AqicnClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirQualityServiceImpl implements AirQualityService {

    private final AqicnClient aqicnClient;
    private final AirQualityMapper mapper;

    @Override
    @Cacheable(value = "citySearchCache", key = "#city")
    public List<CitySearchResponseDto> searchCity(String city) {
        return aqicnClient.searchCity(city);
    }

    @Override
    @Cacheable(value = "airQualityCache", key = "#cityId")
    public AirQualityDto getAirQualityByCityId(String cityId) {
        AirQualityDto data = aqicnClient.getAirQuality(cityId);
        return data;
    }
}
