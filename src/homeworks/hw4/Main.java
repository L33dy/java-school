package homeworks.hw4;

import homeworks.hw4.utils.FileUtil;

import java.util.*;

public class Main {
    private static final Map<String, String> vocabulary = new HashMap<>();
    private static final int minWords = 5;

    private static boolean takingCommands = true;

    public static void main(String[] args) {
        System.out.println("-- Vocabulary Tester --");
        System.out.printf("Enter min. of %d pairs of english words and their czech translations:%n", minWords);

        do {
            System.out.println();
            Scanner scanner = new Scanner(System.in);

            System.out.print("English word: ");
            String englishWord = scanner.nextLine().trim();

            System.out.print("Czech translation: ");
            String czechTranslation = scanner.nextLine().trim();

            vocabulary.put(englishWord, czechTranslation);
            FileUtil.writeToFile(englishWord + "," + czechTranslation);

        } while (vocabulary.size() < minWords);

        System.out.println();

        // handle commands
        handleCommands();
    }

    private static void handleCommands() {
        while (takingCommands) {
            Scanner scanner = new Scanner(System.in);
            String input;

            System.out.print("Enter command: ");
            input = scanner.nextLine().trim();

            switch (input) {
                case "test":
                    test(true);
                    break;
                case "exit":
                    takingCommands = false;
                    break;
            }
        }
    }

    private static void test(boolean fromFile) {
        Set<String> wordsToTest = new HashSet<>();
        Map<String, String> words = fromFile ? FileUtil.readFromFile() : vocabulary;
        int mistakes = 0;

        Random random = new Random();
        String[] keys = words.keySet().toArray(String[]::new);

        while (wordsToTest.size() < Math.min(minWords, 5)) {
            wordsToTest.add(keys[random.nextInt(words.size())]);
        }

        for (String word : wordsToTest) {
            Scanner scanner = new Scanner(System.in);
            String input;

            System.out.print("Enter czech translation of '" + word + "': ");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase(words.get(word))) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
                mistakes++;
            }
        }

        System.out.println("Number of mistakes: " + mistakes);
        System.out.println("Your final grade: " + (Math.min(mistakes + 1, 5)));
    }

}
