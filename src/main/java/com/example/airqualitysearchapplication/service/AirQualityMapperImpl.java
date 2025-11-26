package com.example.airqualitysearchapplication.service;

import com.example.airqualitysearchapplication.dto.AirQualityDto;
import com.example.airqualitysearchapplication.model.AirQualityData;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AirQualityMapperImpl implements AirQualityMapper {

    private final ModelMapper mapper;

    @Override
    public AirQualityDto toDto(AirQualityData data) {
        return mapper.map(data, AirQualityDto.class);
    }
}
