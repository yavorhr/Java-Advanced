
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int size = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix = new int[size][size];
        int incrementN = 1;

        if (pattern.equals("A")) {
            matrix = fillMatrixPatternA(size, incrementN);
        } else if (pattern.equals("B")) {
            matrix = fillMatrixPatternB(size, incrementN);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixPatternA(int size, int incrementN) {
        int[][] matrix = new int[size][size];

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = incrementN++;
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixPatternB(int size, int incrementN) {
        int[][] matrix = new int[size][size];

        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = incrementN++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = incrementN++;
                }
            }
        }
        return matrix;
    }
}