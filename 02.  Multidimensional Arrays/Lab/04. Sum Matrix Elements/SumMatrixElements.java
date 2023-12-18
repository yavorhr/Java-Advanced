import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = readArrayFromConsole(scanner);

        int rows = tokens[0];
        int cols = tokens[1];

        int[][] matrix = fillMatrix(rows, cols, scanner);
        int sum = getSum(matrix);

        printResult(rows, cols, sum);
    }

    private static int[] readArrayFromConsole(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] fillMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = readArrayFromConsole(scanner);
            for (int col = 0; col < arr.length; col++) {
                matrix[row][col] = arr[col];
            }
        }
        return matrix;
    }

    private static int getSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int col = 0; col < arr.length; col++) {
                int currentNum = matrix[row][col];
                sum += currentNum;
            }
        }
        return sum;
    }

    private static void printResult(int rows, int cols, int sum) {
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}