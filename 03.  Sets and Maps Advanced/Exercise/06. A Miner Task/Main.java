import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> mineResources = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            mineResources.putIfAbsent(resource, 0);
            if (mineResources.containsKey(resource)) {
                int currentQuantity = mineResources.get(resource);
                mineResources.put(resource, currentQuantity+quantity);
            }
            input = scanner.nextLine();
        }
        mineResources.entrySet().forEach(entry -> {
            System.out.println(String.format("%s -> %s", entry.getKey(), entry.getValue()));
        });
    }
}















