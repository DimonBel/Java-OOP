package object_interaction;

public class Coffee {
    protected Intensity coffeeIntensity;
    protected final String name = "Coffee";

    public Coffee(Intensity coffeeIntensity) {
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

    // Removed 'final' to allow overriding
    public void printDetails() {
        System.out.println("Coffee intensity: " + coffeeIntensity);
    }

    public Coffee makeCoffee() {
        System.out.println("Making " + name);
        printDetails();
        return this;
    }
}
