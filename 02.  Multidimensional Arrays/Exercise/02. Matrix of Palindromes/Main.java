import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        fillMatrix(scanner, size, matrix);

        int primarySum = getPrimaryDiagonalSum(matrix);
        int secondarySum = getSecondaryDiagonalSum(matrix);

        printResult(primarySum,secondarySum);
    }

    private static void printResult(int primarySum, int secondarySum) {
        System.out.println(Math.abs(primarySum-secondarySum));
    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        int size = matrix.length;

        for (int row = 0; row < size; row++) {
            sum += matrix[size - 1 - row][row];
        }

        return Math.abs(sum);
    }

    private static int getPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        int size = matrix.length;

        for (int row = 0; row < size; row++) {
            sum += matrix[row][row];
        }

        return Math.abs(sum);
    }

    private static void fillMatrix(Scanner scanner, int size, int[][] matrix) {
        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                int currentN = Integer.parseInt(line[col]);
                matrix[row][col] = currentN;
            }
        }

    }
}