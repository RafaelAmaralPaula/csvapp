package com.rafaelamaral.csvapp.resources;

import com.rafaelamaral.csvapp.dto.TemperatureDTO;
import com.rafaelamaral.csvapp.services.TemperatureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/temperatures")
public class TemperatureResource {

    private final TemperatureService temperatureService;

    public TemperatureResource(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping
    public ResponseEntity<List<TemperatureDTO>> listAll() {
        List<TemperatureDTO> list = temperatureService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
