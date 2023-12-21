import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();

        while (n > 0) {
            addElementsToSet(scanner, elements);
            n--;
        }
        printResult(elements);
    }

    private static void addElementsToSet(Scanner scanner, Set<String> elements) {
        elements.addAll(Arrays.asList(scanner.nextLine().split(" ")));
    }

    private static void printResult(Set<String> elements) {
        elements.forEach(e -> System.out.print(e + " "));
    }
}
