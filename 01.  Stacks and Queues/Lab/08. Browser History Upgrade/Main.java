
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        String currentUrl = "";

        String navigation = scanner.nextLine();
        while (!navigation.equals("Home")) {
            if (navigation.equals("back")) {
                if (history.isEmpty()) {
                    printResult("no previous URLs");
                    navigation = scanner.nextLine();
                    continue;
                } else {
                    forwardHistory.push(currentUrl);
                    currentUrl = history.pop();
                }
            } else if (navigation.equals("forward")) {
                if (!forwardHistory.isEmpty()) {
                    history.push(currentUrl);
                    currentUrl = forwardHistory.pop();
                } else {
                    printResult("no next URLs");
                    navigation = scanner.nextLine();
                    continue;
                }
            } else {
                if (!currentUrl.isEmpty()) {
                    history.push(currentUrl);
                    if (!forwardHistory.isEmpty()) {
                        forwardHistory.clear();
                    }
                }
                currentUrl = navigation;
            }
            printResult(currentUrl);
            navigation = scanner.nextLine();
        }
    }

    private static void printResult(String s) {
        System.out.println(s);
    }
}