import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = input.length - 1; i >= 0; i--) {
            stack.push(input[i]);
        }

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String opp = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch (opp) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
                    break;
            }
        }

        System.out.println(stack.peek());
    }
}











































