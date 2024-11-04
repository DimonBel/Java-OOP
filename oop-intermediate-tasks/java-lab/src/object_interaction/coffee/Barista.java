package object_interaction.coffee;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class Barista {

    public void makeCoffeesByName(List<String> coffeeNames) {
        for (String name : coffeeNames) {
            Coffee coffee = createCoffee(name);
            if (coffee != null) {
                coffee.makeCoffee(); // Calls the specific make method
            } else {
                System.out.println("Unknown coffee type: " + name);
            }
        }
    }

    // Method to create coffee based on name
    private Coffee createCoffee(String name) {
        switch (name) {
            case "Americano":
                return new Americano(Intensity.NORMAL, 150);
            case "Cappuccino":
                return new Cappuccino(Intensity.NORMAL, 50);
            case "PumpkinSpiceLatte":
                return new PumpkinSpiceLatte(Intensity.NORMAL, 50, 10);
            case "SyrupCappuccino":
                return new SyrupCappuccino(Intensity.LIGHT, 60, SyrupType.VANILLA);
            default:
                return null;
        }
    }
}
