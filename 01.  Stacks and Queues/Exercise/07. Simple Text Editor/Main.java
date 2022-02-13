import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();

        ArrayDeque<StringBuilder> stackOperations = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] inputSplit = input.split("\\s+");
            String command = inputSplit[0];
            switch (command) {
                case "1":
                    String string = inputSplit[1];
                    text.append(string);
                    stackOperations.push(new StringBuilder(text));
                    break;
                case "2":
                    int eraseCount = Integer.parseInt(inputSplit[1]);
                    int startIndex = text.length() - eraseCount;
                    int endIndex = startIndex + eraseCount;
                    text = text.delete(startIndex, endIndex);
                    stackOperations.push(new StringBuilder(text));
                    break;
                case "3":
                    int index = Integer.parseInt(inputSplit[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    if (stackOperations.size() > 1) {
                        stackOperations.pop();
                        text = stackOperations.peek();
                    } else if (stackOperations.size() == 1) {
                        text = new StringBuilder();
                    }
                    break;
            }
        }
        System.out.println();
    }
}












