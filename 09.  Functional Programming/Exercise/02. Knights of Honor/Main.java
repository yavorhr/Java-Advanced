import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .toArray(String[]::new);

        Consumer<String[]> consumerPrint =
                arr -> Arrays.stream(arr)
                        .forEach(s -> System.out.printf("Sir %s\n", s));

        consumerPrint.accept(input);

    }
}




