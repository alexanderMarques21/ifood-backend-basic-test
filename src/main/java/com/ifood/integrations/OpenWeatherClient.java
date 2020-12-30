package com.ifood.integrations;


import feign.Param;
import feign.RequestLine;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(value = "openWeather", url = "api.openweathermap.org/data/2.5", configuration = WeatherClientConfiguration.class)

public interface OpenWeatherClient {

    @Cacheable("weathers")
    @RequestLine("GET /weather?q={city}&lang=pt_br&lang=pt_br")
    WeatherResponse getWeatherDetails(@Param("city") String city);


}