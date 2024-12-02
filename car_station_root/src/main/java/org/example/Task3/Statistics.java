package org.example.Task3;

public class Statistics {

    private int id = 0; //All cars
    private int ELECTRIC_CONSUMPTION = 0;
    private int GAS_CONSUMPTION = 0;
    private int DINING = 0;
    private int NOT_DINING = 0;
    private int ELECTRIC = 0;
    private int GAS = 0;
    private int PEOPLE = 0;
    private int ROBOTS = 0;


    public void setId(int id) {
        this.id += id;
    }

    public void setELECTRIC_CONSUMPTION(int ELECTRIC_CONSUMPTION) {
        this.ELECTRIC_CONSUMPTION += ELECTRIC_CONSUMPTION;
    }

    public void setGAS_CONSUMPTION(int GAS_CONSUMPTION) {
        this.GAS_CONSUMPTION += GAS_CONSUMPTION;
    }

    public void setDINING(int DINING) {
        this.DINING += DINING;
    }

    public void setNOT_DINING(int NOT_DINING) {
        this.NOT_DINING += NOT_DINING;
    }

    public void setELECTRIC(int ELECTRIC) {
        this.ELECTRIC += ELECTRIC;
    }

    public void setGAS(int GAS) {
        this.GAS += GAS;
    }

    public void setPEOPLE(int PEOPLE) {
        this.PEOPLE += PEOPLE;
    }

    public void setROBOTS(int ROBOTS) {
        this.ROBOTS += ROBOTS;
    }


    public synchronized void showStatistics() {
        System.out.println("===== Statistics =====");
        System.out.println("Total Cars: " + id);
        System.out.println("Total Electric Consumption: " + ELECTRIC_CONSUMPTION + " ");
        System.out.println("Total Gas Consumption: " + GAS_CONSUMPTION + " liters");
        System.out.println("Total Dining: " + DINING);
        System.out.println("Total Not Dining: " + NOT_DINING);
        System.out.println("Total Electric Cars: " + ELECTRIC);
        System.out.println("Total Gas Cars: " + GAS);
        System.out.println("Total People: " + PEOPLE);
        System.out.println("Total Robots: " + ROBOTS);
        System.out.println("=======================");
    }

    public int getId() {
        return id;
    }

    public int getELECTRIC_CONSUMPTION() {
        return ELECTRIC_CONSUMPTION;
    }

    public int getGAS_CONSUMPTION() {
        return GAS_CONSUMPTION;
    }

    public int getDINING() {
        return DINING;
    }

    public int getNOT_DINING() {
        return NOT_DINING;
    }

    public int getELECTRIC() {
        return ELECTRIC;
    }

    public int getGAS() {
        return GAS;
    }

    public int getPEOPLE() {
        return PEOPLE;
    }

    public int getROBOTS() {
        return ROBOTS;
    }
}
