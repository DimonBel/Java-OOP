package org.example.Task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import org.example.Task1.queue;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Semaphore;
import org.example.Task1.queue;
import org.example.Task2.*;
public class Tets_Statstics {


    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("C:\\\\Users\\\\Duma\\\\OneDrive\\\\Рабочий стол\\\\Lab3\\\\queue\\\\Car"+ 1 +".json");
        JsonNode data = mapper.readTree(inputFile);


        // Print only the values from the JSON node
        // Получение значений из полей JSON
        int id = data.get("id").asInt();
        int consumption = data.get("consumption").asInt();
        boolean isDining = data.get("isDining").asBoolean();
        String passengers = data.get("passengers").asText();
        String type = data.get("type").asText();

        Statistics stats = new Statistics();
        stats.setId(id);
        stats.setId(id);
        stats.setELECTRIC_CONSUMPTION(consumption);
        stats.setELECTRIC_CONSUMPTION(consumption);
        stats.setELECTRIC_CONSUMPTION(consumption);
        stats.showStatistics();

    }
}
