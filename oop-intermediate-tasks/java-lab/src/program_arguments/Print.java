package program_arguments;

public class Print {
    public static void printTextDataInfo(TextData textData) {
        System.out.println("File Name: " + textData.getFilename());
        System.out.println("Text: " + textData.getText());
        System.out.println("Number of Vowels: " + textData.getNumberOfVowels());
        System.out.println("Number of Consonants: " + textData.getNumberOfConsonants());
        System.out.println("Total Number of Letters: " + textData.getNumberOfLetters());
        System.out.println("Number of Sentences: " + textData.getNumberOfSentences());
        System.out.println("Longest Word: " + textData.getLongestWord());
        System.out.println("-----------------------------------------------------");
    }
}