import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            switch (command) {
                case "1":
                    int element = Integer.parseInt(input[1]);
                    stack.push(element);
                    break;
                case "2":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "3":
                    // using Collections ->  Collections.max(stack)
                    // using stream API -> System.out.println(stack.stream().mapToInt(Integer::intValue).max().orElse(0));
                    System.out.println(getMaximum(stack));
                    break;
            }
        }
    }

    private static int getMaximum(ArrayDeque<Integer> stack) {
        int max = Integer.MIN_VALUE;

        for (Integer integer : stack) {
            if (integer > max) {
                max = integer;
            }
        }
        return max;
    }
}




