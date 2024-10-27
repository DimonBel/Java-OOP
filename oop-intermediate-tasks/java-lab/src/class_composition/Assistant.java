package class_composition;

import object_interaction.Car;

public class Assistant {
    public static void main(String[] args) {
        System.out.println(" Hello World");
        Car myCar = new Car("Toyota", "Red", 2020);

        // Вызов методов объекта
        myCar.drive();
        myCar.displayInfo();
    }
}
