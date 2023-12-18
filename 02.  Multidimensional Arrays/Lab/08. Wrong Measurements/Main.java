import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = fillMatrix(scanner, size);
        int[] wrongValueCoordinates = readMatrix(scanner);

        int wrongValue = matrix[wrongValueCoordinates[0]][wrongValueCoordinates[1]];

        List<Integer> correctValues = new ArrayList<>();
        List<int[]> indexes = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int col = 0; col < arr.length; col++) {
                if (matrix[row][col] == wrongValue) {
                    indexes.add(new int[]{row, col});
                    int newValue = getCorrectValues(matrix, row, col);
                    correctValues.add(newValue);
                }
            }
        }

        changeWrongValuesInMatrix(matrix,correctValues,indexes);

        printMatrix(matrix);
    }

    private static int[] readMatrix(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void changeWrongValuesInMatrix(int[][] matrix, List<Integer> correctValues, List<int[]> indexes) {
        for (int i = 0; i < indexes.size(); i++) {
            int[] rowAndColl = indexes.get(i);
            matrix[rowAndColl[0]][rowAndColl[1]] = correctValues.get(i);
        }
    }

    private static int getCorrectValues(int[][] matrix, int row, int col) {
        int sum = 0;
        int wrongValue = matrix[row][col];
        if (isInBounds(matrix, row + 1, col) && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }
        if (isInBounds(matrix, row - 1, col) && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }
        if (isInBounds(matrix, row, col + 1) && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }
        if (isInBounds(matrix, row, col - 1) && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }
        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[][] fillMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][];

        for (int row = 0; row < size; row++) {
            int[] arr = readMatrix(scanner);
            for (int col = 0; col < arr.length; col++) {
                matrix[row] = arr;
            }
        }
        return matrix;
    }
}