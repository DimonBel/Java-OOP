package object_interaction.coffee;

// Package-private class (no public modifier)
abstract class Coffee {
    protected Intensity coffeeIntensity;
    protected final String name = "Coffee";

    Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public void setCoffeeIntensity(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public String getName() {
        return name;
    }

    public void printDetails() {
        System.out.println("Coffee intensity: " + coffeeIntensity);
    }

    Coffee makeCoffee() {
        System.out.println("Making " + name);
        printDetails();
        return this;
    }
}
