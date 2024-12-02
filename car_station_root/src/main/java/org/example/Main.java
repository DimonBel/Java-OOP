package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Task1.queue;
import org.example.Task3.Car;
import org.example.Task3.CarStation;
import org.example.Task3.Statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        queue<Car> Carqueue = new queue<>();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3); // Two threads for parallel tasks
        CountDownLatch latch = new CountDownLatch(3); // Latch to wait for two tasks to complete

        // Путь к вашему .exe файлу
        String executablePath = "C:\\Users\\Duma\\OneDrive\\Рабочий стол\\Lab3\\cpp\\src\\man.exe";

        // Параметр для передачи
        String nrOfGenerations = "25"; // Например, 10 генераций

        // Запуск процесса .exe
        Runnable exeTask = () -> {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(executablePath, nrOfGenerations);
                processBuilder.directory(new File("C:\\Users\\Duma\\OneDrive\\Рабочий стол\\Lab3"));
                Process process = processBuilder.start();

                // Чтение стандартного вывода (stdout)
                BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
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
            } finally {
                latch.countDown(); // Уменьшаем счетчик при завершении
            }
        };

        // Чтение файлов JSON и добавление в очередь
        Runnable jsonTask = () -> {
            try {
                for (int i = 1; i <= Integer.parseInt(nrOfGenerations); i++) {
                    Thread.sleep(2800);
                    File inputFile = new File("C:\\\\Users\\\\Duma\\\\OneDrive\\\\Рабочий стол\\\\Lab3\\\\queue\\\\Car" + i + ".json");
                    JsonNode data = mapper.readTree(inputFile);

                    int id = data.get("id").asInt();
                    int consumption = data.get("consumption").asInt();
                    boolean isDining = data.get("isDining").asBoolean();
                    String passengers = data.get("passengers").asText();
                    String type = data.get("type").asText();

                    Car car = new Car(id, type, passengers, consumption, isDining);
                    Carqueue.enqueue(car);
                    System.out.println("--------------------------------------");
                    System.out.printf("Car %d: id=%d, consumption=%d, isDining=%b, passengers=%s, type=%s%n DODODODODODODOODDO",
                            i, id, consumption, isDining, passengers, type);
                    System.out.println("--------------------------------------");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                latch.countDown(); // Уменьшаем счетчик при завершении
            }
        };

        Runnable impl = () -> {
            try {
                Thread.sleep(5000);
                // Обработка после завершения
                Statistics stats = new Statistics();
                Semaphore sem = new Semaphore(2);
                List<Thread> threads = new ArrayList<>();

                // Start CarStation threads
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

                // Check if the queue is empty and display statistics
                if (Carqueue.empty()) {
                    stats.showStatistics();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                latch.countDown(); // Уменьшаем счетчик при завершении
            }
        };


        // Запуск задач параллельно
        scheduler.execute(exeTask);
        Thread.sleep(2000);
        scheduler.execute(jsonTask);
        Thread.sleep(2000);
        scheduler.execute(impl);

        // Ожидание завершения обеих задач
        latch.await();
        // Shutdown the scheduler
        scheduler.shutdown();
    }
}