package com.subhashish.controller;

import com.subhashish.dto.WeatherDTO;
import com.subhashish.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/api/F1-Pro/weather")
public class WeatherController {

    private final static Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);

    WeatherService weatherService;

    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherDTO> getWeather(@PathVariable(name = "city") String cityName){

        LOGGER.info("retrieving weather data for city {}", cityName);
        WeatherDTO weather = weatherService.getCurrentWeather(cityName);
        LOGGER.info("retrieved weather data for city {} : {}", cityName, weather.toString());

        if(weather == null)
            ResponseEntity.notFound().build();

        return ResponseEntity.ok(weather);

    }
}
