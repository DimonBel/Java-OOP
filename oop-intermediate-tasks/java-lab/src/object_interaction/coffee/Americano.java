package object_interaction.coffee;

public class Americano extends Coffee {
    private int mlOfWater;
    private final String coffeeName = "Americano";

    public Americano(Intensity coffeeIntensity, int mlOfWater) {
        super(coffeeIntensity);
        this.mlOfWater = mlOfWater;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Americano water: " + mlOfWater + " ml");
    }

    public Americano makeAmericano() {
        System.out.println("Making Americano");
        super.printDetails();
        System.out.println("Adding " + mlOfWater + " ml of water");
        return this;
    }
}
