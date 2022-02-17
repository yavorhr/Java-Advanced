import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(n -> {
                    numbers.putIfAbsent(n, 0);
                    numbers.put(n, numbers.get(n) + 1);
                });

        String output = numbers.entrySet()
                .stream()
                .map(entry -> String.format("%.1f -> %d", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(output);
    }
}




