import java.util.Scanner;

public class Main {
    public static long[] memoryForFib;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(scanner, rows, columns);
        char[][] secondMatrix = readMatrix(scanner, rows, columns);

        char[][] outputMatrix = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                outputMatrix[row][col] =
                        firstMatrix[row][col] == secondMatrix[row][col]
                                ? firstMatrix[row][col]
                                : '*';
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                char symbol = outputMatrix[row][col];
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    public static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] symbols = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = symbols[col].charAt(0);
            }
        }
        return matrix;
    }
}





