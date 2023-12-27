import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("text.txt");
        List<String> readWordsFromFile = Files.readAllLines(filePath);
        readWordsFromFile = Arrays.asList(readWordsFromFile.get(0).split(" "));

        Scanner scanner = new Scanner(System.in);
        List<String> wordsToFindInput = Arrays.asList(scanner.nextLine().split(" "));
        Map<String, Integer> foundWordsMap = new HashMap<>();

        for (String word : readWordsFromFile) {
            addWordToMap(wordsToFindInput, foundWordsMap, word);
        }

        writeResultToFile(foundWordsMap);
    }

    private static void writeResultToFile(Map<String, Integer> foundWordsMap) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("output.txt");

        foundWordsMap
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(entry -> {
                    String result = String.format("%s - %d", entry.getKey(), entry.getValue());
                    printWriter.println(result);
                });

        printWriter.close();
    }

    private static void addWordToMap(List<String> wordsToFindInput, Map<String, Integer> foundWordsMap, String word) {
        if (wordsToFindInput.contains(word)) {
            foundWordsMap.putIfAbsent(word, 0);
            int currentCount = foundWordsMap.get(word);
            foundWordsMap.put(word, currentCount + 1);
        }
    }

}

