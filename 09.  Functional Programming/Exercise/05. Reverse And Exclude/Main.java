import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> predicate = number -> number % n == 0;

        numbers.removeIf(predicate);
        Collections.reverse(numbers);

        Consumer<List<Integer>> printer = list -> list.forEach(e -> System.out.print(e + " "));
        printer.accept(numbers);
    }
}


