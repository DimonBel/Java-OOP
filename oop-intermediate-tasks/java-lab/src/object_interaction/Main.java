package object_interaction;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ssasaas");

        var model = "Laptop";
        int width = 2;
        int height = 33;
        double ppi = 212.2;

        Display myCar = new Display(width, height, (float) ppi, model);
        myCar.display();
    }
}
