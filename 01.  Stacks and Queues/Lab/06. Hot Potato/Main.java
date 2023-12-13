import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, names);

        while (children.size() > 1) {
            for (int i = 1; i < n; i++) {
                passingPotato(children);
            }
            String removedChild = children.poll();
            printResult(removedChild, "Removed %s\n");
        }
        printResult(children.peek(), "Last is %s\n");
    }

    private static void printResult(String removedChild, String s) {
        System.out.printf(s, removedChild);
    }

    private static void passingPotato(ArrayDeque<String> children) {
        String currentChild = children.poll();
        children.offer(currentChild);
    }
}


