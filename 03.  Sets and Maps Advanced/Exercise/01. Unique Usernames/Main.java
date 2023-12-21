import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> uniqueNames = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            String name = scanner.nextLine();
            uniqueNames.add(name);
            n--;
        }

        printResult(uniqueNames);

    }

    private static void printResult(Set<String> uniqueNames) {
        uniqueNames.forEach(System.out::println);
    }
}
