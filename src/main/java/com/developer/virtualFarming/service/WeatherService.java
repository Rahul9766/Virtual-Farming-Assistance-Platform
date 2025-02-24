package com.developer.virtualFarming.service;

import com.developer.virtualFarming.dto.WeatherForecastDTO;
import java.util.List;
import java.util.Map;

public interface WeatherService {
    Map<String, Object> getWeather(String cityId);
}
