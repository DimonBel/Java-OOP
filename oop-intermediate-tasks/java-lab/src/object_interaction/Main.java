package object_interaction;

public class Main {
    public static void main(String[] args) {
        Coffee basicCoffee = new Coffee(Intensity.NORMAL);
        System.out.println("Basic Coffee:");
        System.out.println("Name: " + basicCoffee.getName());
        System.out.println("Intensity: " + basicCoffee.getCoffeeIntensity());
        System.out.println();

        Cappuccino cappuccino = new Cappuccino(Intensity.STRONG, 150);
        System.out.println("Cappuccino:");
        System.out.println("Name: " + cappuccino.getCoffee());
        System.out.println("Intensity: " + cappuccino.getCoffeeIntensity());
        System.out.println("Milk (ml): " + cappuccino.getMlOfMilk());
        System.out.println();

        PumpkinSpiceLatte pumpkinLatte = new PumpkinSpiceLatte(Intensity.LIGHT, 120, 30);
        System.out.println("Pumpkin Spice Latte:");
        System.out.println("Name: " + pumpkinLatte.getName());
        System.out.println("Intensity: " + pumpkinLatte.getCoffeeIntensity());
        System.out.println("Milk (ml): " + pumpkinLatte.getMlOfMilk());
        System.out.println("Pumpkin Spice (mg): " + pumpkinLatte.getMgOfPumpkinSpice());
        System.out.println();

        Americano americano = new Americano(Intensity.NORMAL, 200);
        System.out.println("Americano:");
        System.out.println("Name: " + americano.getCoffeeName());
        System.out.println("Intensity: " + americano.getCoffeeIntensity());
        System.out.println("Water (ml): " + americano.getMlOfWater());
        System.out.println();

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.STRONG, 150, SyrupType.VANILLA);
        System.out.println("Syrup Cappuccino:");
        System.out.println("Name: " + syrupCappuccino.getCoffee());
        System.out.println("Intensity: " + syrupCappuccino.getCoffeeIntensity());
        System.out.println("Milk (ml): " + syrupCappuccino.getMlOfMilk());
        System.out.println("Syrup Type: " + syrupCappuccino.getSyrup());
    }
}
