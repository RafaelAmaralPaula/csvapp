package com.rafaelamaral.csvapp.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.rafaelamaral.csvapp.entities.Temperature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class File {

    private static final Logger log = LoggerFactory.getLogger(File.class);

    private static final String CSV_FILE_PATH = "files-csv/temperature.csv";

    public List<Temperature> readCSV() {
        List<Temperature> list = new ArrayList<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));

            CsvToBean<Temperature> csvToBean = new CsvToBeanBuilder<Temperature>(reader)
                    .withIgnoreQuotations(true)
                    .withThrowExceptions(false)
                    .withType(Temperature.class)
                    .build();

            var temperatures = csvToBean.parse();

            temperatures.forEach(temperature -> list.add(temperature));

        } catch (IOException ex) {
            log.error(ex.getMessage());
        }

        return list;
    }

}
