package com.ifood.integrations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class WeatherResponse implements Serializable {

    private String tempo;
    private String temperatura;
    private String pressao;
    private String temperaturaMaxima;
    private String temperaturaMinima;
    private String umidade;


    @JsonProperty("main")
    private void setDetails(Map<String, String> details) {
        temperatura = convertToCelsius(details.get("temp"));
        temperaturaMaxima = convertToCelsius(details.get("temp_max"));
        temperaturaMinima = convertToCelsius(details.get("temp_min"));
        pressao = details.get("pressure");
        umidade = details.get("humidity");


    }


    @JsonProperty("weather")
    public void setDescription(List<Map<String, String>> weather) {
        this.tempo = weather.get(0).get("description");
    }

    private String convertToCelsius(String tempString) {
        return new BigDecimal(tempString).subtract(BigDecimal.valueOf(273.15))
                .setScale(0, RoundingMode.CEILING).toString();

    }

    public String getTempo() {
        return tempo;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public String getPressao() {
        return pressao;
    }

    public String getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public String getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public String getUmidade() {
        return umidade;
    }
}
