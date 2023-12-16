import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parentheses = scanner.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();

        boolean areBalanced = true;

        for (int i = 0; i < parentheses.length(); i++) {
            char currentBracket = parentheses.charAt(i);

            if (currentBracket == '(' || currentBracket == '[' || currentBracket == '{') {
                openBrackets.push(currentBracket);
            } else if (currentBracket == ')' || currentBracket == ']' || currentBracket == '}') {
                if (openBrackets.isEmpty()) {
                    areBalanced = false;
                    break;
                }

                char openingBracket = openBrackets.pop();

                if (openingBracket == '(' && currentBracket != ')') {
                    areBalanced = false;
                } else if (openingBracket == '{' && currentBracket != '}') {
                    areBalanced = false;
                } else if (openingBracket == '[' && currentBracket != ']') {
                    areBalanced = false;
                }
            }
        }
        printResult(areBalanced);
    }

    private static void printResult(boolean areBalanced) {
        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}