import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], String> getCount = arr -> String.format("Count = %d", arr.length);
        System.out.println(getCount.apply(nums));

        Function<int[], String> sumNumbers = arr -> {
            return "Sum = " + Arrays.stream(arr).sum();
        };

        System.out.println(sumNumbers.apply(nums));
    }
}





