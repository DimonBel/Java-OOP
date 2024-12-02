package org.example.Task3;

public class Car {

    private int id;
    private String type;
    private String passengers;
    private int consumption;
    private boolean isDining;


    public Car(int id, String type, String passengers, int consumption, boolean isDining) {

        this.id = id;
        this.type = type;
        this.passengers = passengers;
        this.consumption = consumption;
        this.isDining = isDining;

    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", passengers='" + passengers + '\'' +
                ", consumption=" + consumption +
                ", isDining=" + isDining +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public void setDining(boolean dining) {
        isDining = dining;
    }



    public String getType() {
        return type;
    }

    public String getPassengers() {
        return passengers;
    }

    public int getConsumption() {
        return consumption;
    }

    public boolean isDining() {
        return isDining;
    }

    public int getId() {
        return id;
    }
}
