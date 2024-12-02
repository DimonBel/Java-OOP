package org.example.Task2;

public class PeopleDinner implements Dineable{

    @Override
    public void serveDinner(int carId) {
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("Обслужил автомобиль под номером " + carId);
        System.out.println("Покушал человек автомабиля " + carId + ".");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
    }
}
