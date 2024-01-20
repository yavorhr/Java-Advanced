import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int allowedLength = Integer.parseInt(scanner.nextLine());

        String[] names = Arrays.stream(scanner.nextLine()
                .split(" "))
                .toArray(String[]::new);

        Predicate<String> filterByLength = e -> e.length() <= allowedLength;
        Consumer<String> printer = System.out::println;

        Arrays.stream(names)
                .filter(filterByLength)
                .forEach(printer);
    }
}




