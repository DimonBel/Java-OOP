package object_interaction;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ssasaas");

        var model = "Laptop";
        int width = 2;
        int height = 33;
        double ppi = 212.2;

        //Display myCar = new Display(width, height, (float) ppi, model);
        //myCar.display();

        Display monitor1 = new Display(1920, 1080, 82.5f, "Monitor1");
        Display monitor2 = new Display(2560, 1440, 109.5f, "Monitor2");
        Display monitor3 = new Display(3840, 2160, 163.0f, "Monitor3");

        // Compare displays
        monitor1.compareWithMonitor(monitor2);
        System.out.println();
        monitor1.compareWithMonitor(monitor3);
        System.out.println();
        monitor2.compareWithMonitor(monitor3);

    }
}
