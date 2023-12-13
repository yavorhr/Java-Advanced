import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> children = new ArrayDeque();
        Collections.addAll(children, names);

        int cycles = 1;
        while (children.size() > 1) {

            for (int i = 1; i < n; i++) {
                passingPotato(children);
            }

            String child = children.peek();

            if (!isPrime(cycles)) {
                printResult(child, "Removed ");
                children.poll();
            } else {
                printResult(child, "Prime ");
            }
            cycles++;
        }
        String lastChild = children.poll();
        printResult(lastChild, "Last is ");
    }

    private static void passingPotato(ArrayDeque<String> children) {
        String currentChild = children.poll();
        children.offer(currentChild);
    }

    private static void printResult(String child, String s) {
        System.out.println(s + child);
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}














































