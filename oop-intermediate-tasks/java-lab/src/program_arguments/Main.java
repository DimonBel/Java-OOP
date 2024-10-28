package program_arguments;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide at least one path to a .txt file as a command line argument.");
            return;
        }

        FileReader fileReader = new FileReader();

        for (String filePath : args) {
            try {
                String content = fileReader.readFileIntoString(filePath);
                TextData textData = new TextData(content, filePath);
                Print.printTextDataInfo(textData);

            } catch (IOException e) {
                System.out.println("An error occurred while reading the file: " + filePath + " - " + e.getMessage());
            }
        }
    }
}
