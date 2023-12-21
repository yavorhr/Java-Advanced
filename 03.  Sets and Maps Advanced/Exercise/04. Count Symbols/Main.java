import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> countSymbols = new TreeMap<>();
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            addToMap(countSymbols, currentChar);
        }
        printResult(countSymbols);
    }

    private static void printResult(Map<Character, Integer> countSymbols) {
        countSymbols.entrySet().forEach(entry -> System.out.printf("%c: %d time/s\n", entry.getKey(), entry.getValue()));
    }

    private static void addToMap(Map<Character, Integer> countSymbols, char currentChar) {
        countSymbols.putIfAbsent(currentChar, 0);
        int currentCount = countSymbols.get(currentChar);
        countSymbols.put(currentChar, currentCount + 1);
    }
}
