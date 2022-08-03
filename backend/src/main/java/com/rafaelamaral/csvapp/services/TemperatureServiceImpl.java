package com.rafaelamaral.csvapp.services;

import com.rafaelamaral.csvapp.dto.TemperatureDTO;
import com.rafaelamaral.csvapp.entities.Temperature;
import com.rafaelamaral.csvapp.repositories.TemperatureRepository;
import com.rafaelamaral.csvapp.utils.File;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    private final File file;
    private final TemperatureRepository temperatureRepository;

    public TemperatureServiceImpl(File file, TemperatureRepository temperatureRepository) {
        this.file = file;
        this.temperatureRepository = temperatureRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TemperatureDTO> findAll() {
        var list = temperatureRepository.findAll();
        if(list.isEmpty()){
            try {
                save();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return list.stream().map(result-> new TemperatureDTO(result)).collect(Collectors.toList());
    }

    private void save() throws IOException {
        var result = file.readCSV();
        temperatureRepository.saveAll(result);
    }
}
