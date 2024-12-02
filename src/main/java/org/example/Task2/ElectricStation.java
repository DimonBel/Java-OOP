package org.example.Task2;

public class ElectricStation implements Refuelable{


    @Override
    public void refuel(int carId) {
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("Обслужил автомобиль под номером " + carId);
        System.out.println("Заправка автомобиля электричеством " + carId + ".");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
    }
}
