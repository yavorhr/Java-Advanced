import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> allResources = new LinkedHashMap<>();

        String resourceInput = scanner.nextLine();
        while (!"stop".equals(resourceInput)) {
            int quantity = Integer.parseInt(scanner.nextLine());

            addResources(allResources, resourceInput, quantity);

            resourceInput = scanner.nextLine();
        }
        printResult(allResources);
    }

    private static void printResult(Map<String, Integer> allResources) {
        allResources
                .entrySet()
                .forEach(entry -> System.out.printf("%s - %d\n",
                        entry.getKey(),
                        entry.getValue()));
    }

    private static void addResources(Map<String, Integer> allResources, String resourceInput, int quantity) {
        allResources.putIfAbsent(resourceInput, 0);
        int currentQuantity = allResources.get(resourceInput);
        allResources.put(resourceInput, currentQuantity + quantity);
    }
}
