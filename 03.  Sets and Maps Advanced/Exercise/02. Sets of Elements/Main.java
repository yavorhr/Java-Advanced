import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        addNumbersToSet(scanner, firstSet, n);
        addNumbersToSet(scanner, secondSet, m);

        firstSet.retainAll(secondSet);
        printResult(firstSet);
    }

    private static void printResult(LinkedHashSet<Integer> set) {
        set.forEach(n -> System.out.print(n + " "));
    }

    private static void addNumbersToSet(Scanner scanner, LinkedHashSet<Integer> firstSet, int n) {
        while (n > 0) {
            int num = Integer.parseInt(scanner.nextLine());
            firstSet.add(num);

            n--;
        }
    }
}
