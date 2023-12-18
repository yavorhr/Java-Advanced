import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = readArrayFromConsole(scanner);
        int rows = tokens[0];
        int cols = tokens[1];

        int[][] matrix = fillMatrix(rows, cols, scanner);

        int[][] bestMatrix = new int[2][2];
        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int currentSum = matrix[row][col] +
                        matrix[row][col + 1] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1];

                if (currentSum > maxSum) {
                    maxSum = currentSum;

                    bestMatrix[0][0] = matrix[row][col];
                    bestMatrix[0][1] = matrix[row][col + 1];
                    bestMatrix[1][0] = matrix[row + 1][col];
                    bestMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        System.out.println(maxSum);
        printBestMatrix(bestMatrix);
    }

    private static int[] readArrayFromConsole(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void printBestMatrix(int[][] bestMatrix) {
        for (int row = 0; row < bestMatrix.length; row++) {
            int[] arr = bestMatrix[row];
            for (int col = 0; col < arr.length; col++) {
                System.out.print(arr[col] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] fillMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = readArrayFromConsole(scanner);
            matrix[i] = arr;
        }
        return matrix;
    }
}