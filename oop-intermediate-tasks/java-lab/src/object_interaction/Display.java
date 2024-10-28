package object_interaction;

public class Display {

    private String model;
    private int width;
    private int height;
    private float ppi; // Изменено на double

    public Display(int width, int height, float ppi, String model) {
        this.model = model;
        this.width = width;
        this.height = height;
        this.ppi = ppi;
    }

    public String getmodel() {
        return model;
    }

    public int getwidth() {
        return width;
    }

    public float getppi() {
        return ppi;
    }

    public int getheight() {
        return height;
    }

    public void compareSize(Display m) {
        int thisSize = this.width * this.height;
        int otherSize = m.width * m.height;

        if (thisSize > otherSize) {
            System.out.println(this.model + " is bigger in size than " + m.model);
        } else if (thisSize < otherSize) {
            System.out.println(m.model + " is bigger in size than " + this.model);
        } else {
            System.out.println(this.model + " and " + m.model + " are of the same size.");
        }
    }

    // Method to compare sharpness (PPI)
    public void compareSharpness(Display m) {
        if (this.ppi > m.ppi) {
            System.out.println(this.model + " is sharper than " + m.model);
        } else if (this.ppi < m.ppi) {
            System.out.println(m.model + " is sharper than " + this.model);
        } else {
            System.out.println(this.model + " and " + m.model + " have the same sharpness.");
        }
    }

    // Method to compare both size and sharpness
    public void compareWithMonitor(Display m) {
        System.out.println("Comparing " + this.model + " with " + m.model + ":");
        this.compareSize(m);
        this.compareSharpness(m);
    }

    public void display() {
        System.out.println("Model: " + model + ", width: " + width + ", height: " + height + ", ppi: " + ppi);
    }

    @Override
    public String toString() {
        return this.model;
    }
}
