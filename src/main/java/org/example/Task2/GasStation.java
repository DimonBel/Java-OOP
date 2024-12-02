package org.example.Task2;

public class GasStation implements Refuelable{


    @Override
    public void refuel(int carId) {
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("Обслужил автомобиль под номером " + carId);
        System.out.println("Заправка автомобиля газом " + carId + ".");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
    }
}
