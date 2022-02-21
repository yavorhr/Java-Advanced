package Pockemon;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            String name = tokens[1];
            double specialChar = Double.parseDouble(tokens[2]);
            Cat cat = null;

            if (input.contains("Siamise")) {
                cat = new Siamese(name, specialChar);
            } else if (input.contains("Cymric")) {
                cat = new Cymric(name, specialChar);
            } else {
                cat = new StreetExtraordinaire(name, specialChar);
            }
            cats.put(name, cat);

            input = scanner.nextLine();
        }

        String catName = scanner.next();
        System.out.println(cats.get(catName).toString());
    }

}




