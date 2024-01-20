import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listIntegers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findMinNumber = list -> {
            int minNumber = Collections.min(list);
            return list.lastIndexOf(minNumber);
        };

        int indexMinNumber = findMinNumber.apply(listIntegers);

        System.out.println(indexMinNumber);
    }
}


