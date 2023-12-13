import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] argsInputArr = addInputToArray(scanner);
        int[] intsArray = addInputToArray(scanner);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = argsInputArr[0];
        int s = argsInputArr[1];
        int x = argsInputArr[2];

        addIntegersToStack(n, intsArray, stack);
        popNumbersFromStack(s, stack);
        printResult(stack, x);
    }

    private static void printResult(ArrayDeque<Integer> stack, int x) {
        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            printMinValue(stack);
        }
    }

    private static void printMinValue(ArrayDeque<Integer> stack) {
        int minNumber = stack
                .stream()
                .mapToInt(Integer::valueOf)
                .min()
                .orElse(0);
        System.out.println(minNumber);
    }

    private static int[] addInputToArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void addIntegersToStack(int n, int[] arr, ArrayDeque<Integer> stack) {
        for (int i = 0; i < n; i++) {
            stack.push(arr[i]);
        }
    }

    private static void popNumbersFromStack(int s, ArrayDeque<Integer> stack) {
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
    }
}