import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static int MATCHES = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        Arrays.stream(readArray(scanner)).forEach(maleStack::push);

        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        Arrays.stream(readArray(scanner)).forEach(femaleQueue::offer);

        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            int maleValue = maleStack.peek();
            int femaleValue = femaleQueue.peek();

            if (valuesGreaterThanZero(maleValue, femaleValue) && valuesNotDivisibleBy25(maleValue, femaleValue)) {
                if (maleValue == femaleValue) {
                    MATCHES++;
                    maleStack.pop();
                    femaleQueue.poll();
                } else {
                    femaleQueue.poll();
                    int poppedValue = maleStack.pop();
                    maleStack.push(poppedValue - 2);
                }
            } else if (!valuesGreaterThanZero(maleValue, femaleValue)) {
                checkIfValueIsBelowZero(maleStack, maleValue, "stack");
                checkIfValueIsBelowZero(femaleQueue, femaleValue, "queue");
            } else if (!valuesNotDivisibleBy25(maleValue, femaleValue)) {
                checkIfDivisibleBy25(maleStack, maleValue, "stack");
                checkIfDivisibleBy25(femaleQueue, femaleValue, "queue");
            }
        }
        System.out.println(printResult(maleStack, femaleQueue));
    }

    private static String printResult(ArrayDeque<Integer> maleStack, ArrayDeque<Integer> femaleQueue) {
        StringBuilder sb = new StringBuilder(String.format("Matches: %d\n", MATCHES));
        sb.append(String.format("Males left: %s\n", maleStack.isEmpty() ? "none" : getDeckValues(maleStack)));
        sb.append(String.format("Females left: %s", femaleQueue.isEmpty() ? "none" : getDeckValues(femaleQueue)));

        return sb.toString();
    }

    private static String getDeckValues(ArrayDeque<Integer> deck) {
        return deck.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    public static boolean valuesGreaterThanZero(int firstValue, int secondValue) {
        return firstValue > 0 && secondValue > 0;
    }

    public static boolean valuesNotDivisibleBy25(int firstValue, int secondValue) {
        return firstValue % 25 != 0 && secondValue % 25 != 0;
    }

    private static void checkIfValueIsBelowZero(ArrayDeque<Integer> deck, int value, String type) {
        if (value <= 0) {
            if (type.equals("stack")) {
                deck.pop();
            } else {
                deck.poll();
            }
        }
    }

    private static void checkIfDivisibleBy25(ArrayDeque<Integer> deck, int value, String type) {
        if (value % 25 == 0) {
            if (type.equals("stack")) {
                deck.pop();
                deck.pop();
            } else {
                deck.poll();
                deck.poll();
            }
        }
    }

    public static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
