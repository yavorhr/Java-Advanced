import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split("\\s+");
        Predicate<String> checkLength = name -> name.length() <= n;

        Arrays.stream(names)
                .filter(checkLength)
                .forEach(System.out::println);
    }
}

