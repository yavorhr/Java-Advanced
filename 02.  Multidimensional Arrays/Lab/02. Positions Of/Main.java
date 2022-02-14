import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static long[] memoryForFib;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }

        int n = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];
                if (currentNumber == n) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if (!isFound){
            System.out.println("not found");
        }

    }
}



