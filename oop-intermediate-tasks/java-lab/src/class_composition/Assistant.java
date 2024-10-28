package class_composition;

import object_interaction.Display;

import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant() {
        this.assignedDisplays = new ArrayList<>();
    }

    // Adds a Display object to the assignedDisplays list
    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
    }

    // Iterates through assignedDisplays list and compares each Display
    public void assist() {
        if (assignedDisplays.size() < 2) {
            System.out.println("Not enough displays assigned to perform comparisons.");
            return;
        }

        // Iterate through each pair of displays in the assignedDisplays list
        for (int i = 0; i < assignedDisplays.size() - 1; i++) {
            for (int j = i + 1; j < assignedDisplays.size(); j++) {
                Display display1 = assignedDisplays.get(i);
                Display display2 = assignedDisplays.get(j);
                display1.compareWithMonitor(display2);
                System.out.println();
            }
        }
    }

    // Removes a display from the list and returns it
    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            return d;
        } else {
            System.out.println("Display not found in the list.");
            return null;
        }
    }

}
