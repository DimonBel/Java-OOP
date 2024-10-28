package program_arguments;

import java.util.StringTokenizer;

public class TextData {

    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String text, String fileName) {
        this.text = text;
        this.fileName = fileName;
        this.numberOfVowels = countVowels();
        this.numberOfConsonants = countConsonants();
        this.numberOfLetters = numberOfVowels + numberOfConsonants;
        this.numberOfSentences = countSentences();
        this.longestWord = findLongestWord();
    }

    private int countVowels() {
        int vowelsCount = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                vowelsCount++;
            }
        }
        return vowelsCount;
    }

    private int countConsonants() {
        int consonantsCount = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c) && "aeiou".indexOf(c) == -1) {
                consonantsCount++;
            }
        }
        return consonantsCount;
    }

    private int countSentences() {
        int sentenceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == '.' || c == '!' || c == '?') {
                sentenceCount++;
            }
        }
        return sentenceCount;
    }

    // Method to find the longest word
    private String findLongestWord() {
        StringTokenizer tokenizer = new StringTokenizer(text, " \t\n\r.,!?;:");
        String longest = "";
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public String getFilename() {
        return fileName;
    }
    public String getText() {
        return text;
    }
    public int getNumberOfVowels() {
        return numberOfVowels;
    }
    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }
    public int getNumberOfLetters() {
        return numberOfLetters;
    }
    public int getNumberOfSentences() {
        return numberOfSentences;
    }
    public String getLongestWord() {
        return longestWord;
    }
}