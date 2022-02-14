import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        System.out.println(isEqual(firstMatrix, secondMatrix) ? "equal" : "not equal");
    }

    private static boolean isEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secArr = secondMatrix[row];
            if (firstArr.length != secArr.length) {
                return false;
            }
            for (int col = 0; col < firstArr.length; col++) {
                if (firstArr[col] != secArr[col]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int columns = dimensions[1];

        int matrix[][] = new int[rows][columns];

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        return matrix;
    }
}

