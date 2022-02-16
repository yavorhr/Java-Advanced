import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> addressBook = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];

            addressBook.put(name, phoneNumber);

            input = scanner.nextLine();
        }

        String searchContact = scanner.nextLine();

        while (!searchContact.equals("stop")) {
            String contact = searchContact;

            if (!addressBook.containsKey(contact)) {
                System.out.printf("Contact %s does not exist.%n", contact);
            } else {
                System.out.println(String.format("%s -> %s",contact,addressBook.get(contact)));
            }
            searchContact = scanner.nextLine();
        }
    }
}



















