import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        convertDecimalToBinary(decimal, stack);
        printInBinarySystem(stack);
    }

    private static void convertDecimalToBinary(int decimal, ArrayDeque<Integer> stack) {
        while (decimal != 0) {
            int reminder = decimal % 2;
            stack.push(reminder);
            decimal /= 2;
        }
    }

    private static void printInBinarySystem(ArrayDeque<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }
}


