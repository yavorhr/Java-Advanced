import java.util.*;
import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String criteria = scanner.nextLine();
        int startNum = input[0];
        int endNum = input[1];

        Predicate<Integer> filterOddOrEven = createPredicate(criteria);

        printNumbers(startNum, endNum, filterOddOrEven);
    }

    private static Predicate<Integer> createPredicate(String criteria) {
        if (criteria.equals("odd")) {
            return num -> num % 2 != 0;
        }
        return num -> num % 2 == 0;
    }

    private static void printNumbers(int startNum, int endNum, Predicate<Integer> filterOddOrEven) {
        for (int i = startNum; i <= endNum; i++) {
            if (filterOddOrEven.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

}




