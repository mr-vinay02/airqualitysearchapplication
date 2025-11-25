package com.example.airqualitysearchapplication.vendor;

import com.example.airqualitysearchapplication.dto.AirQualityDto;
import com.example.airqualitysearchapplication.dto.CitySearchResponseDto;
import com.example.airqualitysearchapplication.model.AirQualityData;
import com.github.benmanes.caffeine.cache.Cache;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Component
@RequiredArgsConstructor
public class AqicnClient {

    private final WebClient webClient;
    private final ModelMapper modelMapper;

    private final Cache<String, Object> citySearchCache;
    private final Cache<String, Object> airQualityCache;

    @Value("${aqicn.api.base-url}")
    private String baseUrl;

    @Value("${aqicn.api.token}")
    private String apiToken;

    public List<CitySearchResponseDto> searchCity(String city) {
        String cacheKey = "search_" + city.toLowerCase();

        Object cached = citySearchCache.getIfPresent(cacheKey);
        if (cached != null) {
            return (List<CitySearchResponseDto>) cached;
        }

        Map<String, Object> response = webClient.get()
                .uri(baseUrl + "/search/?keyword=" + city + "&token=" + apiToken)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");

        List<CitySearchResponseDto> list = new ArrayList<>();

        if (data != null) {
            for (Map<String, Object> item : data) {
                Map<String, Object> station = (Map<String, Object>) item.get("station");

                CitySearchResponseDto dto = CitySearchResponseDto.builder()
                        .cityId(String.valueOf(item.get("uid")))
                        .cityName(station != null ? (String) station.get("name") : null)
                        .latitude(station != null ? getGeo(station, 0) : null)
                        .longitude(station != null ? getGeo(station, 1) : null)
                        .countryCode(null)
                        .build();

                list.add(dto);
            }
        }

        citySearchCache.put(cacheKey, list);
        return list;
    }

    public AirQualityDto getAirQuality(String cityId) {
        String cacheKey = "aqi_" + cityId;

        Object cached = airQualityCache.getIfPresent(cacheKey);
        if (cached != null) {
            return (AirQualityDto) cached;
        }

        Map<String, Object> response = webClient.get()
                .uri(baseUrl + "/feed/@" + cityId + "/?token=" + apiToken)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        Map<String, Object> data = (Map<String, Object>) response.get("data");

        AirQualityData model = new AirQualityData();

        Map<String, Object> city = (Map<String, Object>) data.get("city");
        List<Double> geo = city != null ? (List<Double>) city.get("geo") : null;

        model.setCityId(cityId);
        model.setCityName(city != null ? (String) city.get("name") : null);
        model.setLatitude(geo != null ? geo.get(0) : null);
        model.setLongitude(geo != null ? geo.get(1) : null);
        model.setAqi((Integer) data.get("aqi"));
        model.setDominantPollutant((String) data.get("dominentpol"));

        Map<String, Object> iaqi = (Map<String, Object>) data.get("iaqi");
        if (iaqi != null) {
            Map<String, Double> pollutants = new HashMap<>();
            for (Map.Entry<String, Object> entry : iaqi.entrySet()) {
                Map<String, Object> v = (Map<String, Object>) entry.getValue();
                if (v.get("v") != null) {
                    pollutants.put(entry.getKey(), Double.valueOf(v.get("v").toString()));
                }
            }
            model.setPollutants(pollutants);
        }

        AirQualityDto dto = modelMapper.map(model, AirQualityDto.class);

        airQualityCache.put(cacheKey, dto);
        return dto;
    }

    private Double getGeo(Map<String, Object> station, int index) {
        List<Double> geo = (List<Double>) station.get("geo");
        if (geo == null || geo.size() <= index) return null;
        return geo.get(index);
    }
}
