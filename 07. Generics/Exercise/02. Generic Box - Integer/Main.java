
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        Box<Integer> box = new Box<>();

        while (n > 0) {
            int num = Integer.parseInt(scanner.nextLine());
            box.add(num);
            n--;
        }

        System.out.println(box);
    }
}

