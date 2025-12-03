package com.subhashish.service;

import com.subhashish.dto.WeatherDTO;
import reactor.core.publisher.Mono;

public interface WeatherService {

    WeatherDTO getCurrentWeather(String city);
}
