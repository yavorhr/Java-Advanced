import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> regular = new HashSet<>();
        Set<String> vip = new HashSet<>();

        String input = scanner.nextLine();
        while (!"PARTY".equals(input)) {

            addGuestToLists(regular, vip, input);

            input = scanner.nextLine();
        }

        Set<String> allGuests = new TreeSet<>(regular);
        allGuests.addAll(vip);

        String guestNameToVisit = scanner.nextLine();
        while (!"END".equals(guestNameToVisit)) {

            allGuests.remove(guestNameToVisit);

            guestNameToVisit = scanner.nextLine();
        }

        printMissingGuests(allGuests);
    }

    private static void printMissingGuests(Set<String> allGuests) {
        System.out.println(allGuests.size());
        allGuests.forEach(System.out::println);
    }

    private static void addGuestToLists(Set<String> regular, Set<String> vip, String input) {
        if (Character.isDigit(input.charAt(0))) {
            vip.add(input);
        } else {
            regular.add(input);
        }
    }
}









