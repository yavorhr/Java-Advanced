import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner, "\\s+");
        }

        int[] validIndexes = readArray(scanner, "\\s+");

        List<int[]> indexes = new ArrayList<>();
        List<Integer> correctValues = new ArrayList<>();

        int wrongValue = matrix[validIndexes[0]][validIndexes[1]];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    indexes.add(new int[]{row, col});
                    correctValues.add(getCorrectValue(matrix, row, col));
                }
            }
        }

        for (int i = 0; i < indexes.size(); i++) {
            int[] rowAndCol = indexes.get(i);
            matrix[rowAndCol[0]][rowAndCol[1]] = correctValues.get(i);
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print (matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int getCorrectValue(int[][] matrix, int row, int col) {
        int sum = 0;

        int wrongValue = matrix[row][col];

        if (isInBound(matrix, row - 1, col) && wrongValue != matrix[row - 1][col]) {
            sum += matrix[row - 1][col];
        }
        if (isInBound(matrix, row + 1, col) && wrongValue != matrix[row + 1][col]) {
            sum += matrix[row + 1][col];
        }
        if (isInBound(matrix, row, col - 1) && wrongValue != matrix[row][col - 1]) {
            sum += matrix[row][col - 1];
        }
        if (isInBound(matrix, row, col + 1) && wrongValue != matrix[row][col + 1]) {
            sum += matrix[row][col + 1];
        }
        return sum;
    }

    private static boolean isInBound(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }


    public static int[] readArray(Scanner scanner, String separator) {
        return Arrays.stream(scanner.nextLine().split(separator))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}