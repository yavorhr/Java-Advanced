import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> catsMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            Cat cat = getCat(input);

            catsMap.put(cat.getName(), cat);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        printCat(catsMap, input);
    }

    private static void printCat(Map<String, Cat> catsMap, String input) {
        Cat currentCat = catsMap.get(input);
        if (currentCat != null) {
            String breed = currentCat.getClass().getName();
            System.out.printf("%s %s", breed, currentCat.toString());
        }
    }

    private static Cat getCat(String input) {
        String[] tokens = input.split(" ");
        String breed = tokens[0];
        String name = tokens[1];
        double specialCharacteristic = Double.parseDouble(tokens[2]);

        Cat cat = null;

        switch (breed) {
            case "StreetExtraordinaire" -> cat = new StreetExtraordinaire(name, specialCharacteristic);
            case "Siamese" -> cat = new Siamese(name, specialCharacteristic);
            case "Cymric" -> cat = new Cymric(name, specialCharacteristic);
        }
        return cat;
    }
}


