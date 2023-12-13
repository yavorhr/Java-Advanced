import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = addNumbersToStack(numbers);

        printStack(stack);
    }

    private static void printStack(ArrayDeque<String> stack) {
        while (!stack.isEmpty()) {
            System.out.printf("%s ", stack.pop());
        }
    }

    private static ArrayDeque<String> addNumbersToStack(String[] numbers) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        Arrays.stream(numbers).forEach(stack::push);
        return stack;
    }
}