import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        fillMatrix(scanner, size, matrix);

//        printDiagonalsWithWhile(size, matrix);
        printDiagonalsWithFor(size, matrix);
    }

    private static void printDiagonalsWithWhile(int size, int[][] matrix) {
        printFirstDiagonalWithWhile(size, matrix);
        System.out.println();
        printSecondDiagonalWithWhile(size, matrix);
    }

    private static void printSecondDiagonalWithWhile(int size, int[][] matrix) {
        int row = size - 1;
        int col = 0;

        while (row >= 0 && col < size) {
            System.out.print(matrix[row][col] + " ");

            row--;
            col++;
        }
    }

    private static void printFirstDiagonalWithWhile(int size, int[][] matrix) {
        int row = 0;
        int col = 0;

        while (row < size && col < size) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }
    }

    private static void printDiagonalsWithFor(int size, int[][] matrix) {
        for (int i = 0; i < size; i++) {
            System.out.print(matrix[i][i] + " ");
        }

        System.out.println();

        for (int row = 0; row < size; row++) {
            System.out.print(matrix[(size - 1) - row][row] + " ");
        }
    }

    private static void fillMatrix(Scanner scanner, int size, int[][] matrix) {
        for (int row = 0; row < size; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
    }


}