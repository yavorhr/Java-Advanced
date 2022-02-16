import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> uniqueUsernames = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            uniqueUsernames.add(input);
        }

        uniqueUsernames.forEach(System.out::print);

    }
}












