import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String[] elements = scanner.nextLine().split(" ");

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int count = Integer.parseInt(input[1]);
        int intInput = Integer.parseInt(input[2]);

        addElementToQueue(elements, queue);

        if (checkSize(queue, count)) {
            removeElement(queue, count);
        }

        printIfIsPresent(queue, intInput);
    }

    private static void printIfIsPresent(ArrayDeque<Integer> queue, int x) {
        if (queue.contains(x)) {
            System.out.println("true");
        } else {
            printMinValue(queue);
        }
    }

    private static void printMinValue(ArrayDeque<Integer> queue) {
        int minValue = getMinElement(queue);
        System.out.println(minValue);
    }

    private static int getMinElement(ArrayDeque<Integer> queue) {
        return queue.stream().mapToInt(i -> i).min().orElse(0);
    }

    private static void removeElement(ArrayDeque<Integer> queue, int count) {
        for (int i = 0; i < count; i++) {
            queue.poll();
        }
    }

    private static boolean checkSize(ArrayDeque<Integer> queue, int s) {
        return s < queue.size();
    }

    private static void addElementToQueue(String[] elements, ArrayDeque<Integer> queue) {
        for (String e : elements) {
            int parseToInt = Integer.parseInt(e);
            queue.offer(parseToInt);
        }
    }
}