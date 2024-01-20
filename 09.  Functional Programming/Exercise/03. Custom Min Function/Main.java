import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersInput = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> findSmallestIntFunc =
                arr -> Arrays.stream(arr)
                        .min()
                        .orElse(0);

        int minNumber = findSmallestIntFunc.apply(numbersInput);

        System.out.println(minNumber);
    }
}




