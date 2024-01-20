import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[], int[]> addConsumer = arr -> Arrays.stream(arr).map(e -> e += 1).toArray();
        Function<int[], int[]> multiplyConsumer = arr -> Arrays.stream(arr).map(e -> e *= 2).toArray();
        Function<int[], int[]> subtractConsumer = arr -> Arrays.stream(arr).map(e -> e -= 1).toArray();
        Consumer<int[]> printConsumer = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        int[] numbersInput = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            switch (command) {
                case "add" -> numbersInput = addConsumer.apply(numbersInput);
                case "multiply" -> numbersInput = multiplyConsumer.apply(numbersInput);
                case "subtract" -> numbersInput = subtractConsumer.apply(numbersInput);
                case "print" -> printConsumer.accept(numbersInput);
            }
            command = scanner.nextLine();
        }

    }
}




