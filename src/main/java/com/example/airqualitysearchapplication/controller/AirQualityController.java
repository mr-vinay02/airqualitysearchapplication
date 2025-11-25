package com.example.airqualitysearchapplication.controller;

import com.example.airqualitysearchapplication.dto.AirQualityDto;
import com.example.airqualitysearchapplication.dto.CitySearchResponseDto;
import com.example.airqualitysearchapplication.service.AirQualityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/air-quality")
@RequiredArgsConstructor
public class AirQualityController {

    private final AirQualityService airQualityService;

    @GetMapping("/search")
    public ResponseEntity<List<CitySearchResponseDto>> searchCity(@RequestParam String city) {
        return ResponseEntity.ok(airQualityService.searchCity(city));
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<AirQualityDto> getAirQuality(@PathVariable String cityId) {
        return ResponseEntity.ok(airQualityService.getAirQualityByCityId(cityId));
    }
}
