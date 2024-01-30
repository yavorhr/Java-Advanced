import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int dollsCount = 0;
    private static int trainsCount = 0;
    private static int teddyBearsCount = 0;
    private static int bicyclesCount = 0;

    private static final int DOLL_VALUE = 150;
    private static final int TRAIN_VALUE = 250;
    private static final int TEDDY_BEAR_VALUE = 300;
    private static final int BICYCLE_VALUE = 400;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialsStack = readDeque(scanner, "stack");
        ArrayDeque<Integer> magicLevelQueue = readDeque(scanner, "queue");

        while (!materialsStack.isEmpty() && !magicLevelQueue.isEmpty()) {
            int magicValue = magicLevelQueue.peek();
            int materialValue = materialsStack.peek();
            int result = magicValue * materialValue;

            if (craftIsPossible(result)) {
                craftPresents(result);
            } else if (zeroInput(magicValue, materialValue)) {
                zeroInputOperation(materialsStack, magicLevelQueue);
            } else if (negativeResult(result)) {
                negativeModification(materialsStack, magicLevelQueue);
            } else if (positiveResult(result)) {
                postiveDequeModification(materialsStack, magicLevelQueue);
            }

        }
    }

    private static void postiveDequeModification(ArrayDeque<Integer> stack, ArrayDeque<Integer> queue) {
        queue.poll();
        int magicValue = stack.pop();
        stack.push(magicValue + 15);
    }

    private static void negativeModification(ArrayDeque<Integer> stack, ArrayDeque<Integer> queue) {

    }

    private static boolean zeroInput(int magicValue, int materialValue) {
        return magicValue == 0 || materialValue == 0;
    }

    private static void zeroInputOperation(ArrayDeque<Integer> stack, ArrayDeque<Integer> queue) {
        stack.pop();
        queue.poll();
    }


    private static boolean craftIsPossible(int result) {
        return result == DOLL_VALUE || result == TRAIN_VALUE || result == TEDDY_BEAR_VALUE || result == BICYCLE_VALUE;
    }

    private static void craftPresents(int result) {
        switch (result) {
            case 150 -> dollsCount++;
            case 250 -> trainsCount++;
            case 300 -> teddyBearsCount++;
            case 400 -> bicyclesCount++;
        }
    }

    private static boolean positiveResult(int result) {
        return result > 0;
    }

    private static boolean resultIsZero(int result) {
        return result == 0;
    }

    private static boolean negativeResult(int result) {
        return result < 0;
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
