import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split(" ");
        Collections.reverse(Arrays.asList(input));
        Arrays.stream(input).forEach(stack::push);

        while (stack.size() > 1) {
            int firstNumber = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());

            switch (operator) {
                case "+" -> calcResult(stack, firstNumber, secondNumber, "+");
                case "-" -> calcResult(stack, firstNumber, secondNumber, "-");
            }
        }

        System.out.println(stack.peek());
    }

    private static void calcResult(ArrayDeque<String> stack, int firstNumber, int secondNumber, String operator) {
        switch (operator) {
            case "+" -> {
                int result = firstNumber + secondNumber;
                stack.push(String.valueOf(result));
            }
            case "-" -> {
                int result = firstNumber - secondNumber;
                stack.push(String.valueOf(result));
            }
        }

    }
}


