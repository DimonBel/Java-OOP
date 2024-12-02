package org.example.test1;

import java.io.*;


public class Program {

    public static void main(String[] args) {
        String executablePath = "C:\\Users\\Duma\\OneDrive\\Рабочий стол\\Lab3\\cpp\\src\\man.exe"; // Path to your compiled C program
        String executablePath1 = "C:\\Users\\Duma\\OneDrive\\Рабочий стол\\Lab3\\man.exe"; // Path to your compiled C program
        // Параметр для передачи
        String nrOfGenerations = "15"; // Например, 20 генераций

        try {
            // Создаем ProcessBuilder с параметром
            ProcessBuilder processBuilder = new ProcessBuilder(executablePath1, nrOfGenerations);
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
