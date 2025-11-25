package com.example.airqualitysearchapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitySearchResponseDto {

    private String cityId;
    private String cityName;

    private Double latitude;
    private Double longitude;

    private String countryCode;
}
