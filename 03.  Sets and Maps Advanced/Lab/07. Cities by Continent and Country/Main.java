import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> continentsData = new LinkedHashMap<>();

        while (n > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            addToMap(continentsData, continent, country, city);

            n--;
        }

        printContinentsMap(continentsData);
    }

    private static void addToMap(Map<String, Map<String, List<String>>> continentsData, String continent, String country, String city) {
        continentsData.putIfAbsent(continent, new LinkedHashMap<>());
        continentsData.get(continent).putIfAbsent(country, new ArrayList<>());
        continentsData.get(continent).get(country).add(city);
    }

    private static void printContinentsMap(Map<String, Map<String, List<String>>> continentsData) {
        continentsData.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ":");

            entry.getValue().entrySet().forEach(innerEntry -> {
                System.out.printf("%s -> %s\n", innerEntry.getKey(), getCitiesPerCountry(innerEntry.getValue()));
            });
        });
    }

    private static String getCitiesPerCountry(List<String> value) {
        return String.join(", ", value);
    }
}
