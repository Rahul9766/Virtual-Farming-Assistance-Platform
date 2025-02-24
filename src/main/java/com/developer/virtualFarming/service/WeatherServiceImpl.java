package com.developer.virtualFarming.service;

import com.developer.virtualFarming.dto.WeatherForecastDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public WeatherServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Map<String, Object> getWeather(String cityId) {
        try {
            // Construct API URL
            String url = String.format("%s?id=%s&appid=%s&units=metric", apiUrl, cityId, apiKey);

            // Fetch weather data
            String jsonResponse = restTemplate.getForObject(url, String.class);

            // Parse JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(jsonResponse);

            // Extract location from city field
            String location = root.path("city").path("name").asText("N/A");

            // Extract first available forecast entry for temperature & humidity
            JsonNode firstForecast = root.path("list").get(0);
            String temperature = firstForecast.path("main").path("temp").asText("N/A") + "°C";
            String humidity = firstForecast.path("main").path("humidity").asText("N/A") + "%";

            // Extract 5-day forecast (next 5 timestamps)
            List<WeatherForecastDTO> forecastList = new ArrayList<>();
            JsonNode forecastArray = root.path("list");

            for (int i = 0; i < 5 && i < forecastArray.size(); i++) {  // Limit to 5 entries
                JsonNode dayNode = forecastArray.get(i);
                String date = dayNode.path("dt_txt").asText("N/A");  // Date from API
                String temp = dayNode.path("main").path("temp").asText("N/A") + "°C";

                forecastList.add(new WeatherForecastDTO(date, temp));
            }

            // Return structured response
            return Map.of(
                    "location", location,
                    "temperature", temperature,
                    "humidity", humidity,
                    "forecast", forecastList
            );

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch weather data: " + e.getMessage());
        }
    }
}
