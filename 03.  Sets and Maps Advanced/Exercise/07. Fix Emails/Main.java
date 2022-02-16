import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            String userName = input;
            String emailAddress = scanner.nextLine();

            int dotIndex = emailAddress.lastIndexOf('.');
            String domain = emailAddress.substring(dotIndex + 1);

            if (domain.equals("bg")) {
                emails.put(userName, emailAddress);
            }
            input = scanner.nextLine();
        }
        emails.entrySet().forEach(entry -> {
            System.out.println(String.format("%s -> %s",entry.getKey(),entry.getValue()));
        });
    }
}

















