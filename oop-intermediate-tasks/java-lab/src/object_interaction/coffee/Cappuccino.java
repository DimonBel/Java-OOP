package object_interaction.coffee;

public class Cappuccino extends Coffee {
    protected int mlOfMilk;
    protected final String coffee = "Cappuccino";

    public Cappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        super(coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Cappuccino milk: " + mlOfMilk + " mg");
    }

    public Cappuccino makeCappuccino() {
        System.out.println("Making " + coffee);
        super.printDetails();
        System.out.println("Adding " + mlOfMilk + " mg of milk");
        return this;
    }
}
