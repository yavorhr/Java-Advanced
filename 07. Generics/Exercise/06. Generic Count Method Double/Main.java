import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        Box<Double> box = new Box<>();

        while (n > 0) {
            double input = Double.parseDouble(scanner.nextLine());
            box.add(input);
            n--;
        }

        double doubleInput = Double.parseDouble(scanner.nextLine());
        int countElements = box.getGreaterCountOfElements(doubleInput);

        printGreaterElementsCount(countElements);
    }

    private static void printGreaterElementsCount(int count) {
        System.out.println(count);
    }

}

