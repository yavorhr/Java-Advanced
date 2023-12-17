
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = fillMatrix(scanner, rows, cols);
        char[][] secondMatrix = fillMatrix(scanner, rows, cols);
        char[][] outputMatrix = getIntersectedMatrix(firstMatrix, secondMatrix, rows, cols);

        printOutputMatrix(outputMatrix, rows, cols);
    }

    private static void printOutputMatrix(char[][] outputMatrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col == cols - 1) {
                    System.out.print(outputMatrix[row][col]);
                } else {
                    System.out.print(outputMatrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    public static char[][] fillMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(" ");

            for (int col = 0; col < input.length; col++) {
                char currentSymbol = input[col].charAt(0);
                matrix[row][col] = currentSymbol;
            }
        }
        return matrix;
    }

    public static char[][] getIntersectedMatrix(char[][] firstMatrix, char[][] secondMatrix, int rows, int cols) {
        char[][] outputMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                outputMatrix[row][col] =
                        firstMatrix[row][col] == secondMatrix[row][col]
                                ? firstMatrix[row][col]
                                : '*';
            }
        }
        return outputMatrix;
    }
}

