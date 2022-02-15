import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int sumFirstDiagonal = firstDiagonalSum(matrix);
        int sumSecDiagonal = secondDiagonalSum(matrix);

        int result = Math.abs(sumFirstDiagonal - sumSecDiagonal);
        System.out.println(result);
    }

    private static int secondDiagonalSum(int[][] matrix) {
        int sumSecDiagonal = 0;
        int size = matrix.length;

        for (int index = 0; index < size; index++) {
            int currNum = matrix[(size - 1) - index][index];
            sumSecDiagonal += currNum;
        }
        return sumSecDiagonal;
    }

    private static int firstDiagonalSum(int[][] matrix) {
        int sumSecDiagonal = 0;
        int size = matrix.length;

        for (int index = 0; index < size; index++) {
            int currNum = matrix[index][index];
            sumSecDiagonal += currNum;
        }
        return sumSecDiagonal;
    }

    private static int[][] readMatrix(Scanner scanner) {
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        return (matrix);
    }
}



