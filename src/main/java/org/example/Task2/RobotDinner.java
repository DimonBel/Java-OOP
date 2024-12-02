package org.example.Task2;

public class RobotDinner implements Dineable{

    @Override
    public void serveDinner(int carId) {
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("Обслужил автомобиль под номером " + carId);
        System.out.println("Покушал робот автомабиля " + carId + ".");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
    }
}
