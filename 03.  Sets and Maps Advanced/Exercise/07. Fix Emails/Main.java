import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> allEmails = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!"stop".equals(name)) {
            String email = scanner.nextLine();

            addEmail(allEmails, name, email);

            name = scanner.nextLine();
        }
        printResult(allEmails);
    }

    private static void printResult(Map<String, String> allEmails) {
        allEmails
                .entrySet()
                .forEach(entry -> System.out.printf("%s - %s\n",
                        entry.getKey(),
                        entry.getValue()));
    }

    private static void addEmail(Map<String, String> allEmails, String name, String email) {
        String domain = email.substring(email.indexOf('.')+1);
        if (domain.equals("bg")) {
            allEmails.putIfAbsent(name, email);
        }
    }
}
