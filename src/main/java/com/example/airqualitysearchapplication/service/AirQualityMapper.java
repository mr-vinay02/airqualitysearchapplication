package com.example.airqualitysearchapplication.service;

import com.example.airqualitysearchapplication.dto.AirQualityDto;
import com.example.airqualitysearchapplication.model.AirQualityData;

public interface AirQualityMapper {

    AirQualityDto toDto(AirQualityData data);
}