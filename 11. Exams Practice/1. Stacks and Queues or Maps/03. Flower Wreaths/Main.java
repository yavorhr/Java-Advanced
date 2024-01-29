import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int wreaths = 0;
    public static int storedFlowers = 0;
    public static final int REQUIRED_WREATHS = 5;
    public static final int VALUE_TO_MATCH = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = readDeque(scanner, "stack");
        ArrayDeque<Integer> rosesQueue = readDeque(scanner, "queue");

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int lilly = liliesStack.peek();
            int rose = rosesQueue.peek();
            int sum = lilly + rose;

            combineFlowers(liliesStack, rosesQueue, sum);
        }

        wreaths += storedFlowers / VALUE_TO_MATCH;
        printOutput();
    }

    private static void printOutput() {
        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!\n", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!\n", REQUIRED_WREATHS - wreaths);
        }
    }

    private static void combineFlowers(ArrayDeque<Integer> liliesStack, ArrayDeque<Integer> rosesQueue, int sum) {
        if (sum == VALUE_TO_MATCH) {
            wreaths++;
            removeOneFlowerPerDeck(liliesStack, rosesQueue);
        } else if (sum > VALUE_TO_MATCH) {
            int poppedValue = liliesStack.pop();
            liliesStack.push(poppedValue - 2);
        } else {
            storedFlowers += sum;
            removeOneFlowerPerDeck(liliesStack, rosesQueue);
        }
    }

    private static void removeOneFlowerPerDeck(ArrayDeque<Integer> liliesStack, ArrayDeque<Integer> rosesQueue) {
        liliesStack.pop();
        rosesQueue.poll();
    }

    public static ArrayDeque<Integer> readDeque(Scanner scanner, String type) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        if (type.equals("stack")) {
            Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(deque::push);
        } else {
            Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(deque::offer);
        }
        return deque;
    }
}
