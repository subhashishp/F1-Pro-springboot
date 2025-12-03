package com.subhashish.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.subhashish.dto.WeatherDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherServiceImpl implements WeatherService{

    private final static Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);

    private final ObjectMapper mapper= new ObjectMapper();
    private final WebClient webClient;
    private final String apiKey = "8cd9259951b94b67b11154537253011";

    public WeatherServiceImpl(WebClient weatherWebClient) {
        this.webClient = weatherWebClient;
    }

    @Override
    public WeatherDTO getCurrentWeather(String city) {

        LOGGER.info(" called for city {}", city);

        String weatherJsonReponse = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/current.json")
                        .queryParam("key",apiKey)
                        .queryParam("q",city)
                        .build())
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("Weather API error")))
                .bodyToMono(String.class)
                .block();

        LOGGER.info(" data received for city {}", weatherJsonReponse);

        if(weatherJsonReponse == null || weatherJsonReponse.isBlank())
            return null;

        WeatherDTO weather = new WeatherDTO();
        try {
            JsonNode root = mapper.readTree(weatherJsonReponse);
            weather = mapToWeatherDto(root);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        return weather;
    }

    public WeatherDTO mapToWeatherDto(JsonNode root){
        WeatherDTO weatherDTO = new WeatherDTO();

        weatherDTO.setCity(root.get("location").get("name").asText());
        weatherDTO.setRegion(root.get("location").get("region").asText());
        weatherDTO.setCountry(root.get("location").get("country").asText());
        weatherDTO.setCondition(root.get("current").get("condition").get("text").asText());
        weatherDTO.setTemperatureC(root.get("current").get("temp_c").asDouble());
        weatherDTO.setTemperatureF(root.get("current").get("temp_f").asDouble());
        weatherDTO.setHumidity(root.get("current").get("humidity").asInt());
        weatherDTO.setCloud(root.get("current").get("cloud").asInt());
        weatherDTO.setWindSpeed(root.get("current").get("wind_kph").asDouble());

        return weatherDTO;
    }
}
