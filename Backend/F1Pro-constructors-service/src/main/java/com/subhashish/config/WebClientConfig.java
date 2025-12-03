package com.subhashish.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient weatherWebClient() {
        return WebClient.builder()
                .baseUrl("http://api.weatherapi.com/v1")
                .defaultHeader("Accept", "application/json")
                .build();
    }
}
