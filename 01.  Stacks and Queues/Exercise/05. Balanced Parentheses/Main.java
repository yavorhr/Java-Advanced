import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        boolean areBalanced = true;
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            if (currentBracket == '{' || currentBracket == '[' || currentBracket == '(') {
                openBrackets.push(currentBracket);
            }
            else if (currentBracket == '}' || currentBracket == ']' || currentBracket == ')') {
                if (openBrackets.isEmpty()){
                    areBalanced=false;
                    break;
                }
                char lastOpenBracket = openBrackets.pop();
                if (currentBracket == ')' && lastOpenBracket != '(') {
                    areBalanced = false;
                } else if (currentBracket == ']' && lastOpenBracket != '[') {
                    areBalanced = false;
                } else if (currentBracket == '}' && lastOpenBracket != '{') {
                    areBalanced = false;
                }
            }

        }

        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}









