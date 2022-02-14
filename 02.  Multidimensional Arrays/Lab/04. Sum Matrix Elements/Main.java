import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine()
                    .split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int sum = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int currentNumber = matrix[r][c];
                sum += currentNumber;
            }
        }

        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }
}







