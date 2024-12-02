package org.example.Task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GasStationTest {

    private GasStation gasStation;
    int carId = 123;

    @Test
    void refuel() {
        gasStation = new GasStation();
        gasStation.refuel(carId);
    }
}