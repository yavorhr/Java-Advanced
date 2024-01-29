import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = readDeque(scanner, " ");
        ArrayDeque<Integer> threadsQueue = readDeque(scanner, ", ");

        int task = Integer.parseInt(scanner.nextLine());

        while (!tasksStack.isEmpty() && !threadsQueue.isEmpty()) {
            int threadValue = threadsQueue.peek();
            int taskValue = tasksStack.peekFirst();

            if (taskValue == task) {
                System.out.printf("Thread with value %d killed task %d\n", threadValue, taskValue);
                break;
            } else if (threadValue >= taskValue) {
                tasksStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }
        }

        printRemainingThreads(threadsQueue);
    }

    private static void printRemainingThreads(ArrayDeque<Integer> threadsQueue) {
        threadsQueue.forEach(t -> System.out.print(t + " "));
    }

    private static ArrayDeque<Integer> readDeque(Scanner scanner, String delimiter) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        if (delimiter.equals(" ")) {
            Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(deque::push);
            return deque;
        } else {
            Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(deque::offer);
        }
        return deque;
    }
}
