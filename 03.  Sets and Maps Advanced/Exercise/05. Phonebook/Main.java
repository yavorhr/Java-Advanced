import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];

            phoneBook.put(name, number);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("stop")) {
            String name = input;

            printResult(phoneBook, name);

            input = scanner.nextLine();
        }
    }

    private static void printResult(Map<String, String> phoneBook, String name) {
        if (phoneBook.containsKey(name)) {
            System.out.printf("%s -> %s\n", name, phoneBook.get(name));
        } else {
            System.out.printf("Contact %s does not exist.\n", name);
        }
    }
}
