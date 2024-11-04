package object_interaction.coffee;

public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;
    private final String name = "PumpkinSpiceLatte";

    public PumpkinSpiceLatte(Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(coffeeIntensity, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Pumpkin Spice: " + mgOfPumpkinSpice + " mg");
    }

    public PumpkinSpiceLatte makePumpkinSpiceLatte() {
        System.out.println("Making Pumpkin Spice Latte");
        super.printDetails();
        System.out.println("Adding " + mlOfMilk + " mls of milk");
        System.out.println("Adding " + mgOfPumpkinSpice + " mls of pumpkin spice");
        return this;
    }
}
