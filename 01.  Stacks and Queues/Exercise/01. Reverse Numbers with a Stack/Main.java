import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stackNumbers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(stackNumbers::push);

        while (!stackNumbers.isEmpty()) {
            System.out.print(stackNumbers.pop() + " ");
        }
    }
}
