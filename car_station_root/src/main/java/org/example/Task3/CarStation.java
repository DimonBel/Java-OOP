package org.example.Task3;


import org.example.Task1.queue;
import org.example.Task2.*;

import java.util.concurrent.Semaphore;


public class CarStation extends Thread{

    private queue<Car> carqueue; // Declare carqueue
    private Semaphore sem; // Semaphore for synchronization
    private int id; // ID for this thread (or station)
    private Statistics statistics;

    public CarStation(queue<Car> carqueue, Semaphore sem, int id, Statistics statistics) {
        this.carqueue = carqueue;
        this.sem = sem;
        this.id = id;
        this.statistics = statistics;
    }

    @Override
    public void run() {
        try {
            while (!carqueue.empty())  {
                sem.acquire(); // Acquire the semaphore to serve the cars

                // Serve the car at the rear of the queue
                serveCars();
                sem.release(); // Release the semaphore after serving the car

                // Wait a bit before serving another car (optional)
                Thread.sleep(3500);

            }
        } catch (InterruptedException e) {
            System.out.println("CarStation " + id + " interrupted.");
        }
    }

    public void serveCars(){

        //Statistics stats = new Statistics();
        Car car = carqueue.rear();
        String type = car.getType();
        int id = car.getId();
        String Passengers = car.getPassengers();
        int consumption = car.getConsumption();
        boolean isDinning = car.isDining();

        ElectricStation Station = new ElectricStation();
        GasStation gasStation = new GasStation();
        PeopleDinner peopleDinner = new PeopleDinner();
        RobotDinner robotDinner = new RobotDinner();


        if (type.equals("GAS")){
            gasStation.refuel(id);
            statistics.setGAS_CONSUMPTION(consumption);
            statistics.setGAS(1);

        } else if (type.equals("ELECTRIC")){
            Station.refuel(id);
            statistics.setELECTRIC(1);
            statistics.setELECTRIC_CONSUMPTION(consumption);
        } else {
            System.out.println("Unknown fuel type");
        }

        if (Passengers.equals("PEOPLE")){
            peopleDinner.serveDinner(id);
            statistics.setPEOPLE(1);

        } else if (Passengers.equals("ROBOTS")){
                robotDinner.serveDinner(id);
            statistics.setROBOTS(1);
        } else {
            System.out.println("Unknown Passengers");
        }

        if (isDinning){
            statistics.setDINING(1);
        } else {
            statistics.setNOT_DINING(1);
        }

        statistics.setId(1);
        carqueue.dequeue();
        System.out.println(carqueue);

    }


}
