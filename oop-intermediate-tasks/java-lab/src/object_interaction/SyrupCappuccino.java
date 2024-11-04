package object_interaction;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    private final String coffee = "SyrupCappuccino";

    public SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, mlOfMilk);
        this.syrup = syrup;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Syrup type: " + syrup);
    }

    public SyrupCappuccino makeSyrupCappuccino() {
        System.out.println("Making Syrup Cappuccino");
        super.printDetails();
        System.out.println("Adding " + mlOfMilk + " mls of milk");
        System.out.println("Adding syrup: " + syrup);
        return this;
    }
}
