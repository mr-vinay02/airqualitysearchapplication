package com.example.airqualitysearchapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirQualityData {

    private String cityId;
    private String cityName;
    private Double latitude;
    private Double longitude;

    private int aqi;
    private String category;
    private String dominantPollutant;

    private Map<String, Double> pollutants;

    private LocalDateTime lastUpdated;

    private Map<String, String> attribution;
}
