import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continentsAndCities = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            continentsAndCities.putIfAbsent(continent, new LinkedHashMap<>());
            continentsAndCities.get(continent).putIfAbsent(country, new ArrayList<>());
            continentsAndCities.get(continent).get(country).add(city);
        }
        continentsAndCities.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ":");

            entry.getValue().entrySet().forEach(innerEntry -> {
                System.out.println(innerEntry.getKey() + " -> " + String.join(", ",innerEntry.getValue()) );
            });
        });
    }
}








