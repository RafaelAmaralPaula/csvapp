package com.rafaelamaral.csvapp.dto;

import com.rafaelamaral.csvapp.entities.Temperature;

import java.io.Serializable;

public class TemperatureDTO implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String temperature;
    private String time;

    public TemperatureDTO(){}

    public TemperatureDTO(String temperature, String time) {
        this.temperature = temperature;
        this.time = time;
    }

    public TemperatureDTO(Temperature entity) {
        temperature = entity.getTemperature();
        time = entity.getTime();
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
