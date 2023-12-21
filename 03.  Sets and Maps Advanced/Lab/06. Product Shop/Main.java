import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> registry = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"Revision".equals(input)) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            Double price = Double.parseDouble(tokens[2]);

            addProductsToShop(registry, shop, product, price);

            input = scanner.nextLine();
        }

        registry.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().forEach(innerEntry -> {
                System.out.printf("Product: %s, Price: %.2f\n", innerEntry.getKey(), innerEntry.getValue());
            });
        });
    }

    private static void addProductsToShop(Map<String, Map<String, Double>> registry, String market, String product, Double price) {
        registry.putIfAbsent(market, new HashMap<>());
        Map<String, Double> products = registry.get(market);
        products.put(product, price);
        registry.put(market, products);
    }
}
