package org.example.Task3;
import org.example.Task1.queue;
import org.example.Task2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

import static org.junit.jupiter.api.Assertions.*;

public class CarStationTest {

    private queue<Car> carQueue;
    private Semaphore semaphore;
    private Statistics statistics;
    private CarStation carStation;
    private Car car;

    @BeforeEach
    public void setUp() {

        carQueue = new queue<>();
        semaphore = new Semaphore(1);
        statistics = new Statistics();


        car = new Car(1, "GAS", "PEOPLE", 10, true); // example data
        carQueue.enqueue(car);


        carStation = new CarStation(carQueue, semaphore, 1, statistics);
    }

    @Test
    public void testServeCars_GasStation()  {

        carStation.serveCars();
        assertEquals(1, statistics.getGAS());
        assertEquals(10, statistics.getGAS_CONSUMPTION());
    }

    @Test
    public void testServeCars_ElectricStation()  {
        car.setType("ELECTRIC");
        carStation.serveCars();

        // Check  statistics  updated
        assertEquals(1, statistics.getELECTRIC());
        assertEquals(10, statistics.getELECTRIC_CONSUMPTION());
    }

    @Test
    public void testServeCars_PeopleDinner() {
        // Call the method that serves the cars
        carStation.serveCars();

        // Check if statistics were updated correctly
        assertEquals(1, statistics.getPEOPLE()); // people dinner should be served
    }

    @Test
    public void testServeCars_RobotDinner()  {
        car.setPassengers("ROBOTS");
        carStation.serveCars();
        assertEquals(1, statistics.getROBOTS());
    }

    @Test
    public void testServeCars_Dining()  {
        carStation.serveCars();
        assertEquals(1, statistics.getDINING()); // car is dining
    }

    @Test
    public void testRun()  {
        // Call the run method to test if it correctly processes the car
        carStation.run();
        assertTrue(carQueue.empty()); // carQueue should be empty after serving the car
    }

    @Test
    public void testCarQueueEmpty()  {
        // Simulate an empty queue
        carQueue.dequeue();
        carStation.run();
        assertTrue(carQueue.empty());
    }

    @Test
    public void testSemaphore() {

        carStation.run();

    }
}