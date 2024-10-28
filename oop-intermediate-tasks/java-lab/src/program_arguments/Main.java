package program_arguments;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Please provide the path to a .txt file as a command line argument.");
            return;
        }

        String filePath = args[0];
        FileReader fileReader = new FileReader();

        try {
            String content = fileReader.readFileIntoString(filePath);

            TextData textData = new TextData(content, filePath);

            System.out.println("File Name: " + textData.getFilename());
            System.out.println("Text: " + textData.getText());
            System.out.println("Number of Vowels: " + textData.getNumberOfVowels());
            System.out.println("Number of Consonants: " + textData.getNumberOfConsonants());
            System.out.println("Total Number of Letters: " + textData.getNumberOfLetters());
            System.out.println("Number of Sentences: " + textData.getNumberOfSentences());
            System.out.println("Longest Word: " + textData.getLongestWord());

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
