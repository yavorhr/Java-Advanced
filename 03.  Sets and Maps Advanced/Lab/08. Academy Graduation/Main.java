import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> registry = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            String name = scanner.nextLine();

            double avgGrade = getAvgGrade(scanner);

            String currentStudentResult = String.format("%s is graduated with %.4f", name, avgGrade);
            registry.put(name, currentStudentResult);

            n--;
        }

        printResult(registry);
    }

    private static void printResult(Map<String, String> registry) {
        registry.values().forEach(System.out::println);
    }

    private static double getAvgGrade(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::valueOf).average().getAsDouble();
    }
}
