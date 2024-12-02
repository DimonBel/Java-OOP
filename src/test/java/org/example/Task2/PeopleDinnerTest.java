package org.example.Task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PeopleDinnerTest {
    private PeopleDinner peopleDinner;
    int carId = 123;
    @Test
    void serveDinner() {
        peopleDinner = new PeopleDinner();
        peopleDinner.serveDinner(carId);
    }
}