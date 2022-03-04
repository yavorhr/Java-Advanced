import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tasksStack::push);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(threadsQueue::offer);

        int valueOfTask = Integer.parseInt(scanner.nextLine());

        boolean killedTask = false;
        while (!tasksStack.isEmpty() && !threadsQueue.isEmpty()) {
            int firstTask = tasksStack.peekFirst();
            int firstThread = threadsQueue.peek();

            if (firstTask == valueOfTask) {
                break;
            }

            if (firstThread >= firstTask) {
                tasksStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }
        }

        System.out.println(String.format("Thread with value %d killed task %d",threadsQueue.peek(),tasksStack.peek()));
        while (!threadsQueue.isEmpty()) {
            System.out.print(threadsQueue.poll() + " ");
        }
    }
}


