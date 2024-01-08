import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = readNumber(scanner);
        Box<Integer> box = new Box<>();

        while (n > 0) {
            int num = Integer.parseInt(scanner.nextLine());
            box.add(num);
            n--;
        }

        int firstIndex = scanner.nextInt();
        int secondIndex = readNumber(scanner);

        if (isValid(firstIndex, box.getSize()) && isValid(secondIndex, box.getSize())) {
            box.swapElements(firstIndex, secondIndex);
        } else {
            System.out.println("Invalid indexes!");
        }

        printBoxElements(box);
    }

    private static void printBoxElements(Box<Integer> box) {
        System.out.println(box);
    }

    private static boolean isValid(int index, int size) {
        return index >= 0 && index < size;
    }

    private static int readNumber(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();
        return n;
    }
}

