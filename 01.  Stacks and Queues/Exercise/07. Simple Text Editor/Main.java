import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();
        ArrayDeque<StringBuilder> stack = new ArrayDeque<>();

        while (n > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];

            switch (command) {
                case "1" -> {
                    String substring = tokens[1];
                    text.append(substring);
                    stack.push(new StringBuilder(text));
                }
                case "2" -> {
                    int eraseCount = Integer.parseInt(tokens[1]);

                    if (isInBounds(text, eraseCount)) {
                        removeElements(text, eraseCount);
                        stack.push(new StringBuilder(text));
                    }
                }
                case "3" -> {
                    int index = Integer.parseInt(tokens[1]);
                    if (isInBounds(text, index)) {
                        System.out.println(text.charAt(index - 1));
                    }
                }
                case "4" -> {
                    if (stack.size() > 1) {
                        stack.pop();
                        text = stack.peek();
                    } else if (stack.size() == 1) {
                        text = new StringBuilder();
                    }
                }
            }
            n--;
        }
    }

    private static boolean isInBounds(StringBuilder text, int eraseCount) {
        return eraseCount >= 0 && eraseCount <= text.toString().length();
    }

    private static void removeElements(StringBuilder text, int eraseCount) {
        int startIndex = text.length() - eraseCount;
        int endIndex = startIndex + eraseCount;
        text.delete(startIndex, endIndex);
    }
}