import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> countNumbers = new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).forEach(n -> {
            countNumbers.putIfAbsent(n, 0);

            int incrementCurrentCount = countNumbers.get(n) + 1;
            countNumbers.put(n, incrementCurrentCount);
        });


        printMap(countNumbers);
    }

    private static void printMap(Map<Double, Integer> countNumbers) {
        String result = countNumbers
                .entrySet()
                .stream()
                .map(e -> String.format("%.1f -> %d",
                        e.getKey(),
                        e.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(result);
    }
}









