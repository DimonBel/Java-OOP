package org.example.Task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectricStationTest {
    private ElectricStation electricStation;

    int carId = 123;
    @Test
    void refuel() {

        electricStation = new ElectricStation();
        electricStation.refuel(carId);
    }
}