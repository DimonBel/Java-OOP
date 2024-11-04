package object_interaction;

public class Main {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Intensity.NORMAL, 50);
        Cappuccino madeCappuccino = cappuccino.makeCappuccino();
        System.out.println();

        PumpkinSpiceLatte pumpkinLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 100, 50);
        PumpkinSpiceLatte madePumpkinLatte = pumpkinLatte.makePumpkinSpiceLatte();
        System.out.println();

        Americano americano = new Americano(Intensity.STRONG, 150);
        Americano madeAmericano = americano.makeAmericano();
        System.out.println();

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.LIGHT, 60, SyrupType.VANILLA);
        SyrupCappuccino madeSyrupCappuccino = syrupCappuccino.makeSyrupCappuccino();
    }
}
