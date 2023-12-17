import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrixUsingStream(scanner);
        int[][] secondMatrix = readMatrixUsingLoop(scanner);

        System.out.println(compareMatrices(firstMatrix, secondMatrix) ? "equal" : "not equal");
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            int[] firstArr = firstMatrix[i];
            int[] secondArr = secondMatrix[i];
            if (firstArr.length != secondArr.length) {
                return false;
            }
            for (int j = 0; j < firstArr.length; j++) {
                if (firstArr[j] != secondArr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] readMatrixUsingStream(Scanner scanner) {
        int[] dimensions = readArrayFromConsole(scanner);
        int rows = dimensions[0];

        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] arr = readArrayFromConsole(scanner);
            matrix[i] = arr;
        }

        return matrix;
    }

    private static int[][] readMatrixUsingLoop(Scanner scanner) {
        int[] dimensions = readArrayFromConsole(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = readArrayFromConsole(scanner);
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = arr[col];
            }
        }
        return matrix;
    }

    private static int[] readArrayFromConsole(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}