import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Add" -> {
                    String charSequence = tokens[1];
                    customList.add(charSequence);
                }
                case "Remove" -> {
                    int index = Integer.parseInt(tokens[1]);
                    customList.remove(index);
                }
                case "Contains" -> {
                    String searchElement = tokens[1];
                    System.out.println(customList.contains(searchElement));
                }
                case "Swap" -> {
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    customList.swap(firstIndex, secondIndex);
                }
                case "Greater" -> {
                    String elementToCompare = tokens[1];
                    System.out.println(customList.countGreaterThan(elementToCompare));
                }
                case "Max" -> System.out.println(customList.getMax());
                case "Min" -> System.out.println(customList.getMin());
                case "Print" -> System.out.println(customList);
                default -> System.out.println("Invalid command");
            }
            input = scanner.nextLine();
        }

        Sorter.sort(customList);
        System.out.println(customList);

        List<String> list = new ArrayList<>();
    }
}

