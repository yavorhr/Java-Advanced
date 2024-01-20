import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<Integer> filterEvenNumbers = e -> e % 2 == 0;

        String result = Arrays.stream(scanner.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .filter(filterEvenNumbers::test)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        printResult(result);

        result = Arrays.stream(result
                .split(", "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        printResult(result);
    }

    private static void printResult(String result) {
        System.out.println(result);
    }
}


