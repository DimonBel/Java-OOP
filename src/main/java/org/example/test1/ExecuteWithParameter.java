package org.example.test1;

import java.io.*;

public class ExecuteWithParameter {
    public static void main(String[] args) {
        // Путь к вашему .exe файлу
        String executablePath = "C:\\Users\\Duma\\OneDrive\\Рабочий стол\\Lab3\\cpp\\src\\man.exe";

        // Параметр для передачи
        String nrOfGenerations = "15"; // Например, 10 генераций

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
    }
}
