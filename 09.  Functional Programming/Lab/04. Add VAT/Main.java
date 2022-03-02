import java.util.*;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> vatAdder = (priceWithoutVat -> priceWithoutVat * 1.20);
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(e -> vatAdder.apply(Double.parseDouble(e)))
                .forEach(e -> System.out.printf("%.2f%n", e));
    }
}


