import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> costs = new TreeMap<>();
        String line = scanner.nextLine();
        while (!line.equalsIgnoreCase("Revision")) {
            String[] tokens = line.split(", ");

            String shop = tokens[0];
            String product = tokens[1];
            Double price = Double.parseDouble(tokens[2]);

            costs.putIfAbsent(shop, new LinkedHashMap<>());
            costs.get(shop).put(product, price);

            line = scanner.nextLine();
        }

        costs.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + "->");
                    entry.getValue()
                            .entrySet()
                            .stream()
                            .forEach(innerEntry -> {
                                System.out.printf("Product: %s, Price: %.1f%n",
                                        innerEntry.getKey(),
                                        innerEntry.getValue());
                            });
                });
    }
}







