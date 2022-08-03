package com.rafaelamaral.csvapp.services;

import com.rafaelamaral.csvapp.dto.TemperatureDTO;

import java.util.List;


public interface TemperatureService {

    List<TemperatureDTO> findAll();

}
