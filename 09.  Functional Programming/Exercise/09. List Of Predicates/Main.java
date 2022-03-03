import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersAsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        BiFunction<List<Integer>, Integer, Boolean> predicate = ((list, number) -> {
            for (Integer numInList : list) {
                if (number % numInList != 0) {
                    return false;
                }
            }
            return true;
        });

        for (int number = 1; number <= n; number++) {
            if (predicate.apply(numbersAsList, number)) {
                System.out.print(number + " ");
            }
        }
    }
}
