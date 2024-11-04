package object_interaction;

import object_interaction.coffee.Barista;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Barista barista = new Barista();

        // Coffee order as a list of names
        List<String> coffeeNames = Arrays.asList("Americano", "Cappuccino", "PumpkinSpiceLatte", "SyrupCappuccino");

        // Barista prepares the coffee based on names
        barista.makeCoffeesByName(coffeeNames);
    }
}