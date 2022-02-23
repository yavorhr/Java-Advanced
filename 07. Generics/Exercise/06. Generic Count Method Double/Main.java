import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> box = new Box();
        for (int i = 0; i < n; i++) {
            double number = Double.parseDouble(scanner.nextLine());
            box.add(number);
        }

        double elementToCompare = Double.parseDouble(scanner.nextLine());
        int countGreater = box.countGreaterThan(elementToCompare);
        System.out.println(countGreater);
    }
}
