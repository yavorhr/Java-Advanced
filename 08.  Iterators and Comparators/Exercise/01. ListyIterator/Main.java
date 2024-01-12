import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListIterator listIterator = null;

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(" ");

            String command = tokens[0];
            switch (command) {
                case "Create" -> {
                    if (tokens.length == 1) {
                        listIterator = new ListIterator();
                    } else {
                        List<String> names = Arrays.stream(tokens).skip(1).collect(Collectors.toList());
                        listIterator = new ListIterator(names);
                    }
                }
                case "Move" -> System.out.println(listIterator.move());

                case "HasNext" -> System.out.println(listIterator.hasNext());

                case "Print" -> System.out.println(listIterator.print());

            }
            input = scanner.nextLine();
        }

    }

}



