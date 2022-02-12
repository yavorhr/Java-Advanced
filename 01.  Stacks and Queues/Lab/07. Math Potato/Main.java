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
                String currentChild = children.poll();
                children.offer(currentChild);
            }

            String child = children.peek();
            if (!isPrime(cycles)) {
                System.out.println("Removed " + child);
                children.poll();
            } else {
                System.out.println("Prime " + child);

            }

            cycles++;
        }
        String lastChild = children.poll();
        System.out.println("Last is " + lastChild);
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














































