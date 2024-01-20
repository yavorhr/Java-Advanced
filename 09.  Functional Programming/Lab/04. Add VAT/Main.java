import java.util.*;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> addVatFunction = e -> e *= 1.2;

        StringBuilder outputSb = new StringBuilder("Prices with VAT:\n");

        Arrays.stream(scanner.nextLine()
                .split(","))
                .mapToDouble(Double::parseDouble)
                .map(addVatFunction::apply)
                .forEach(e -> outputSb
                        .append(String.format("%.2f", e))
                        .append(System.lineSeparator()));

        System.out.print(outputSb);
    }
}




