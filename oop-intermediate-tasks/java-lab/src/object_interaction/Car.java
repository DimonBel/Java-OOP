package object_interaction;

public class Car {
    // Поля (атрибуты) класса
    private String model;
    private String color;
    private int year;

    // Публичный конструктор
    public Car(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }

    // Публичный метод
    public void drive() {
        System.out.println("The car is driving!");
    }

    // Публичный метод, который выводит информацию о машине
    public void displayInfo() {
        System.out.println("Model: " + model + ", Color: " + color + ", Year: " + year);
    }
}
