import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nameList = scanner.nextLine().split("\\s+");

        Consumer<String[]> consumerPrint = stringArr -> {
            for (String name : stringArr) {
                System.out.printf("Sir %s%n", name);
            }
        };
        consumerPrint.accept(nameList);
    }
}
