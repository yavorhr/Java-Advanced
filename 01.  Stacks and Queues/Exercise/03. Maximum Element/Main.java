import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (n > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];

            switch (command) {
                case "1" -> {
                    int integer = Integer.parseInt(tokens[1]);
                    stack.push(integer);
                }
                case "2" -> stack.pop();
                case "3" -> {
                    int maxElement = getMaxValue(stack);
                    printMaxElement(maxElement);
                }
            }
            n--;
        }
    }

    private static void printMaxElement(int maxElement) {
        System.out.println(maxElement);
    }

    private static int getMaxValue(ArrayDeque<Integer> stack) {

//     Using Stream API
//       int maxElement = stack
//               .stream()
//               .mapToInt(Integer::valueOf)
//               .max()
//               .orElse(0);

        int maxValue = Integer.MIN_VALUE;

        for (Integer number : stack) {
            if (number > maxValue) {
                maxValue = number;
            }
        }
        return maxValue;
    }
}