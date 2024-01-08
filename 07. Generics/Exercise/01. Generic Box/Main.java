
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        Box<String> box = new Box<>();

        while (n > 0) {
            String input = scanner.nextLine();
            box.add(input);
            n--;
        }

        System.out.println(box);
    }
}

