package org.example.Task3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Task1.queue;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import org.example.Task1.queue;
import org.example.Task2.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Check {

    public static void main(String args[]) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    queue<Car> Carqueue = new queue<>();
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Путь к вашему .exe файлу
        String executablePath = "C:\\Users\\Duma\\OneDrive\\Рабочий стол\\Lab3\\cpp\\src\\man.exe";

        // Параметр для передачи
        String nrOfGenerations = "5"; // Например, 10 генераций

        try {
            // Создаем ProcessBuilder с параметром
            ProcessBuilder processBuilder = new ProcessBuilder(executablePath, nrOfGenerations);

            // Устанавливаем рабочий каталог на тот же, где находится ваш .exe
            processBuilder.directory(new File("C:\\Users\\Duma\\OneDrive\\Рабочий стол\\Lab3"));

            // Запускаем процесс
            Process process = processBuilder.start();

            // Чтение стандартного вывода (stdout)
            BufferedReader outputReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            System.out.println("Вывод программы:");
            while ((line = outputReader.readLine()) != null) {
                System.out.println(line);
            }

            // Ожидание завершения программы
            int exitCode = process.waitFor();
            System.out.println("Программа завершилась с кодом: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 1; i <= Integer.parseInt(nrOfGenerations); i++ ) {
            File inputFile_test = new File("C:\\\\Users\\\\Duma\\\\OneDrive\\\\Рабочий стол\\\\Lab3\\\\queue\\\\Car"+ i +".json");
            JsonNode data_test = mapper.readTree(inputFile_test);
            // Print the data node
            //System.out.println(data);

            // Print only the values from the JSON node
            // Получение значений из полей JSON
            int id_test = data_test.get("id").asInt();
            int consumption_test = data_test.get("consumption").asInt();
            boolean isDining_test = data_test.get("isDining").asBoolean();
            String passengers_test = data_test.get("passengers").asText();
            String type_test = data_test.get("type").asText();


            Car car = new Car( id_test, type_test, passengers_test, consumption_test, isDining_test);
            Carqueue.enqueue(car);
            // Вывод значений в формате параметров
            System.out.printf("Car %d: id=%d, consumption=%d, isDining=%b, passengers=%s, type=%s%n",
                    i, id_test, consumption_test, isDining_test, passengers_test, type_test);
        }
        Statistics stats = new Statistics();
        Semaphore sem = new Semaphore(2);
        List<Thread> threads = new ArrayList<>();

 //Start CarStation threads
        for (int i = 1; i < 2; i++) {
            Thread thread = new CarStation(Carqueue, sem, i, stats);
            threads.add(thread);
            thread.start();
        }

// Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

// Now check if the queue is empty and display statistics
        if (Carqueue.empty()) {
            stats.showStatistics();
        }
    }

}

