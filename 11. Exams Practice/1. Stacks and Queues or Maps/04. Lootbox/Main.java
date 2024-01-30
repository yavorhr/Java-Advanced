import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int claimedItemsSum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = readDeque(scanner, "queue");
        ArrayDeque<Integer> secondBoxStack = readDeque(scanner, "stack");

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstValue = firstBoxQueue.peekFirst();
            int secondValue = secondBoxStack.peek();

            manipulateLootBoxes(firstBoxQueue, secondBoxStack, firstValue, secondValue);
        }

        printResult(firstBoxQueue, secondBoxStack);

    }

    private static void manipulateLootBoxes(ArrayDeque<Integer> firstBoxQueue, ArrayDeque<Integer> secondBoxStack, int firstValue, int secondValue) {
        int sum = firstValue + secondValue;

        if (sum % 2 == 0) {
            firstBoxQueue.poll();
            secondBoxStack.pop();
            claimedItemsSum += sum;
        } else {
            secondBoxStack.pop();
            firstBoxQueue.offer(secondValue);
        }
    }

    private static void printResult(ArrayDeque<Integer> firstBoxQueue, ArrayDeque<Integer> secondBoxStack) {
        StringBuilder sb = new StringBuilder();

        if (firstBoxQueue.isEmpty()) {
            sb.append("First lootbox is empty\n");
        }

        if (secondBoxStack.isEmpty()) {
            sb.append("Second lootbox is empty\n");
        }

        if (claimedItemsSum >= 100) {
            sb.append(String.format("Your loot was epic! Value: %d\n", claimedItemsSum));
        } else {
            sb.append(String.format("Your loot was poor... Value: %d\n", claimedItemsSum));
        }

        System.out.println(sb);
    }

    public static ArrayDeque<Integer> readDeque(Scanner scanner, String type) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        if (type.equals("stack")) {
            Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(deque::push);
        } else {
            Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(deque::offer);
        }
        return deque;
    }
}
