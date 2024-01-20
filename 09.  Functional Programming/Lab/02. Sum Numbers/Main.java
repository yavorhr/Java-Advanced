import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Function<String, int[]> parserFunc = s ->
                Arrays.stream(s
                        .split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int[] arrayNumbers = parserFunc.apply(input);
        printResult("Count = %d\n", arrayNumbers.length);

        Function<int[], Integer> getSumFunc = array -> Arrays.stream(array).sum();
        int sumArr = getSumFunc.apply(arrayNumbers);

        printResult("Sum = %d\n", sumArr);
    }

    private static void printResult(String s2, int length) {
        System.out.printf(s2, length);
    }
}


