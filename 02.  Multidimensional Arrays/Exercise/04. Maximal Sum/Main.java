import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];
        fillMatrix(scanner, rows, matrix);

        List<Integer> bestValues = new ArrayList<>();
        List<int[]> bestMatrixIndexes = new ArrayList<>();

        findBestMatrix(matrix, bestValues, bestMatrixIndexes);
        printMatrix(matrix, bestValues, bestMatrixIndexes);
    }

    private static void printMatrix(int[][] matrix, List<Integer> valuesList, List<int[]> coordinatesList) {
        int maxSum = valuesList.get(valuesList.size() - 1);
        int startRow = coordinatesList.get(coordinatesList.size() - 1)[0] - 1;
        int startCol = coordinatesList.get(coordinatesList.size() - 1)[1] - 1;

        System.out.printf("Sum = %d\n", maxSum);

        for (int row = startRow; row <= startRow + 2; row++) {
            for (int col = startCol; col <= startCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void findBestMatrix(int[][] matrix, List<Integer> bestValues, List<int[]> bestMatrixCoordinates) {
        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col - 1] + matrix[row][col + 1]
                        + matrix[row - 1][col] + matrix[row - 1][col + 1] + matrix[row - 1][col - 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col - 1];

                if (sum > maxSum) {
                    maxSum = sum;
                    startRow = row;
                    startCol = col;

                    bestMatrixCoordinates.add(new int[]{startRow, startCol});
                    bestValues.add(maxSum);
                }

            }
        }
    }

    private static void fillMatrix(Scanner scanner, int rows, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            int[] arr = readArrayFromConsole(scanner);
            for (int col = 0; col < arr.length; col++) {
                matrix[row][col] = arr[col];
            }
        }
    }

    private static int[] readArrayFromConsole(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }


}