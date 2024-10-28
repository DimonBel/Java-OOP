package class_composition;

import object_interaction.Display;

public class Main {
    public static void main(String[] args) {
        Assistant assistant = new Assistant();

        Display display1 = new Display(1920, 1080, 82.5f, "Monitor1");
        Display display2 = new Display(2560, 1440, 109.5f, "Monitor2");
        Display display3 = new Display(3840, 2160, 163.0f, "Monitor3");

        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);

        assistant.assist();

        Display boughtDisplay = assistant.buyDisplay(display2);
        System.out.println("Bought Display: " + boughtDisplay.toString());

        assistant.assist();
    }
}
