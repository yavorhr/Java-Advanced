import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        List<int[]> listWithArrays = new ArrayList<>();

        fillMatrix(matrix, scanner);

        int number = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < matrix.length; row++) {
            int[] currentArray = matrix[row];
            for (int col = 0; col < currentArray.length; col++) {
                int currentNumber = matrix[row][col];

                if (currentNumber == number) {
                    listWithArrays.add(new int[]{row, col});
                }
            }
        }

        if (listWithArrays.isEmpty()) {
            System.out.println("not found");
        } else {
            listWithArrays.forEach(arr -> System.out.println(arr[0] + " " + arr[1]));
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        return new int[rows][cols];
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            matrix[row] = arr;
        }
    }
}