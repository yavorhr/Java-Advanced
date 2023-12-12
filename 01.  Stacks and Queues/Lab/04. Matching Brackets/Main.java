import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '(') {
                stack.push(i);
            } else if (currentChar == ')') {
                int openIndex = stack.pop();
                int closingIndex = i + 1;

                printSubstring(input, openIndex, closingIndex);
            }
        }

    }

    private static void printSubstring(String input, int openIndex, int closingIndex) {
        System.out.println(input.substring(openIndex, closingIndex));
    }
}


