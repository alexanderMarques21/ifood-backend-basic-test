package com.ifood.controllers;

import com.ifood.integrations.OpenWeatherClient;
import com.ifood.integrations.WeatherResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class Weather {

    @Autowired
    private OpenWeatherClient openWeatherClient;


    @GetMapping
    @CircuitBreaker(name = "weather", fallbackMethod = "weatherFallback")
    public ResponseEntity<?> execute(@RequestParam(name = "city") String city) {
        WeatherResponse resp = openWeatherClient.getWeatherDetails(city);
        return ResponseEntity.ok(resp);
    }

    private ResponseEntity<String> weatherFallback(Exception e) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Sorry we couldn't connect to an required external server");
    }
}
