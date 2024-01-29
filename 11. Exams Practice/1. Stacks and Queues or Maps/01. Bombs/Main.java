import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final int DATURA_VALUE = 40;
    private static final int CHERRY_VALUE = 60;
    private static final int SMOKE_VALUE = 120;

    private static int DATURA_COUNT = 0;
    private static int CHERRY_COUNT = 0;
    private static int SMOKE_COUNT = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effectsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> casingsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(effectsQueue::offer);
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(casingsStack::push);

        while (!casingsStack.isEmpty() && !effectsQueue.isEmpty() && !bombPouchIsReached()) {
            int sum = effectsQueue.peek() + casingsStack.peek();

            if (createBombIsSuccessful(sum)) {
                effectsQueue.poll();
                casingsStack.pop();
            } else {
                int poppedValue = casingsStack.pop();
                casingsStack.push(poppedValue - 5);
            }
        }
        printOutput(effectsQueue, casingsStack);
    }

    private static void printOutput(ArrayDeque<Integer> effectsQueue, ArrayDeque<Integer> casingsStack) {
        if (bombPouchIsReached()) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (effectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.printf("Bomb Effects: %s\n", getValues(effectsQueue));
        }

        if (casingsStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.printf("Bomb Casings: %s\n", getValues(casingsStack));
        }
        System.out.printf("Cherry Bombs: %d\nDatura Bombs: %d\nSmoke Decoy Bombs: %d\n", CHERRY_COUNT, DATURA_COUNT, SMOKE_COUNT);
    }

    private static String getValues(ArrayDeque<Integer> deque) {
        return deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    private static boolean createBombIsSuccessful(int sum) {
        if (sum != DATURA_VALUE && sum != CHERRY_VALUE && sum != SMOKE_VALUE) {
            return false;
        }

        if (sum == DATURA_VALUE) {
            DATURA_COUNT += 1;
        } else if (sum == CHERRY_VALUE) {
            CHERRY_COUNT += 1;
        } else {
            SMOKE_COUNT += 1;
        }
        return true;
    }

    private static boolean bombPouchIsReached() {
        return CHERRY_COUNT >= 3 && SMOKE_COUNT >= 3 && DATURA_COUNT >= 3;
    }
}
