import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];

        int startN = 1;

        if (pattern.equals("A")) {
            fillPatternA(size, matrix, startN);
        } else if (pattern.equals("B")) {
            fillPatternB(size, matrix, startN);
        }

        printMatrix(matrix,size,size);
    }

    private static void fillPatternB(int size, int[][] matrix, int startN) {

        for (int col = 0; col < size; col++) {
            //Четна -> от 0 до SIZE
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = startN++;
                }
            } else {
                //Нечетна -> от SIZE-1 до 0
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = startN++;
                }
            }
        }
    }

    private static void fillPatternA(int size, int[][] matrix, int startN) {
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = startN++;
            }
        }
    }

    private static void printMatrix(int[][] matrix,int rows,int cols) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

