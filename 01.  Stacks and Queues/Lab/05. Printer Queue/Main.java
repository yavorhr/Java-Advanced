import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String expression = scanner.nextLine();

        for (int i = 0; i < expression.length(); i++) {
            char currChar = expression.charAt(i);
            if (currChar == '(') {
                stack.push(i);
            } else if (currChar == ')') {
                int openingIndex = stack.pop();
                int closingIndex = i;
                System.out.println(expression.substring(openingIndex,closingIndex+1));
            }
        }

    }
}













































