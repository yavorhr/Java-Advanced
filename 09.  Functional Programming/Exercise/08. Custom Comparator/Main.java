import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> collect = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Comparator<Integer> customComparator = ((a, b) -> {
            if (a % 2 == 0 && b % 2 == 0) {
                return a.compareTo(b);
            } else if (a % 2 == 0) {
                return -1;
            } else if (b % 2 == 0) {
                return 1;
            }
            return a.compareTo(b);
        });

        collect.stream().
                sorted(customComparator)
                .forEach(n -> System.out.print(n+ " "));

    }
}
