import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vips = new LinkedHashSet<>();
        Set<String> regular = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!"PARTY".equals(input)) {
            if (Character.isDigit(input.charAt(0))) {
                vips.add(input);
            } else {
                regular.add(input);
            }
            input = scanner.nextLine();
        }

        Set<String> allGuests = new TreeSet<>(vips);
        allGuests.addAll(regular);

        while (!"END".equals(input)) {
            allGuests.remove(input);

            input = scanner.nextLine();

        }

        System.out.println(allGuests.size());
        System.out.println(String.join(System.lineSeparator(), allGuests));
    }
}
