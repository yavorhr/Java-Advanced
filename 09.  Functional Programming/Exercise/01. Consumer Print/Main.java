import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordsNames = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Consumer<List<String>> consumerPrint = printList -> wordsNames.forEach(System.out::println);

        consumerPrint.accept(wordsNames);
    }
}
