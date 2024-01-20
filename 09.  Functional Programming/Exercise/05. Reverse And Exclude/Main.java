import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listIntegers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Collections.reverse(listIntegers);

        int number = Integer.parseInt(scanner.nextLine());

        removeDivisibleNumbersFromList(listIntegers, number);
        printList(listIntegers);
    }

    private static void printList(List<Integer> listIntegers) {
        Consumer<List<Integer>> printer = list -> list.forEach(n -> System.out.print(n + " "));
        printer.accept(listIntegers);
    }

    private static void removeDivisibleNumbersFromList(List<Integer> listIntegers, int number) {
        Predicate<Integer> dividedByCustomNumber = num -> num % number == 0;
        listIntegers.removeIf(dividedByCustomNumber);
    }
}




