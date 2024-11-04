package object_interaction;

public class Main {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Intensity.NORMAL, 50);
        cappuccino.printDetails();
        System.out.println();

        PumpkinSpiceLatte pumpkinLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 100, 50);
        pumpkinLatte.printDetails();
    }
}
