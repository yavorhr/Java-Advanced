import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        firstSet.retainAll(secondSet);

        firstSet.forEach(number -> System.out.print(number + " "));
    }
}













