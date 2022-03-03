import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[], Integer> findSmallest = arrIntegers ->
                Arrays.stream(arrIntegers)
                        .min()
                        .getAsInt();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findSmallest.apply(numbers));
    }
}

