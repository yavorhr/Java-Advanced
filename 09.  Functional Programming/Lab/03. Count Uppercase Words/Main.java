import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Predicate<String> filterByUppercase = s -> Character.isUpperCase(s.charAt(0));

        String[] arr = Arrays.stream(input
                .split(" "))
                .filter(filterByUppercase)
                .toArray(String[]::new);

        printOutput(arr);
    }

    private static void printOutput(String[] arr) {
        System.out.println(arr.length);
        System.out.println(Arrays.stream(arr).collect(Collectors.joining(System.lineSeparator())));
    }
}



