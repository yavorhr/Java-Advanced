import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> countSymbols = new TreeMap<>();
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char currSymbol = input.charAt(i);

            if (countSymbols.containsKey(currSymbol)) {
                int currentCount = countSymbols.get(currSymbol);
                countSymbols.put(currSymbol, currentCount + 1);
            } else {
                countSymbols.putIfAbsent(currSymbol, 1);
            }
        }

        countSymbols.entrySet().forEach(e -> {
            System.out.println(String.format("%c: %d time/s", e.getKey(), e.getValue()));
        });
    }
}
















