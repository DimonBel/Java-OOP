package org.example.Task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotDinnerTest {
private RobotDinner robotDinner;
int carId = 123;
    @Test
    void serveDinner() {
        robotDinner = new RobotDinner();
        robotDinner.serveDinner(carId);
    }
}