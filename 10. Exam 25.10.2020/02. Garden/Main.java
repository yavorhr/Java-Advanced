import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[][] matrix = readMatrix(scanner.nextLine());

    String input = scanner.nextLine();
    while (!input.equals("Bloom Bloom Plow")) {
      int[] dimensions = readArrFromConsole(input);

      if (!isInBounds(dimensions, matrix)) {
        System.out.println("Invalid coordinates");
        input = scanner.nextLine();
        continue;
      }

      plantFlower(matrix, dimensions);

      bloomFlowersLeft(dimensions, matrix);
      bloomFlowersRight(dimensions, matrix);
      bloomFlowersUp(dimensions, matrix);
      bloomFlowersDown(dimensions, matrix);

      input = scanner.nextLine();
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

  private static void bloomFlowersUp(int[] dimensions, int[][] matrix) {
    int startRow = dimensions[0];
    int startCol = dimensions[1];

    for (int row = startRow; row >= 0; row--) {
      matrix[row][startCol]++;
    }
    matrix[startRow][startCol]--;
  }

  private static void bloomFlowersDown(int[] dimensions, int[][] matrix) {
    int startRow = dimensions[0];
    int startCol = dimensions[1];

    for (int row = startRow; row < matrix.length; row++) {
      matrix[row][startCol]++;
    }
    matrix[startRow][startCol]--;
  }

  private static void bloomFlowersRight(int[] dimensions, int[][] matrix) {
    int startRow = dimensions[0];
    int startCol = dimensions[1];

    for (int col = startCol; col < matrix[startRow].length; col++) {
      matrix[startRow][col]++;
    }

    matrix[startRow][startCol]--;
  }

  private static void bloomFlowersLeft(int[] dimensions, int[][] matrix) {
    int startRow = dimensions[0];
    int startCol = dimensions[1];

    for (int col = startCol; col >= 0; col--) {
      matrix[startRow][col]++;
    }

    matrix[startRow][startCol]--;
  }

  private static void plantFlower(int[][] matrix, int[] dimensions) {
    int startRow = dimensions[0];
    int startCol = dimensions[1];

    matrix[startRow][startCol] = 1;
  }

  private static boolean isInBounds(int[] dimensions, int[][] matrix) {
    int row = dimensions[0];
    int col = dimensions[1];

    return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
  }

  private static int[][] readMatrix(String input) {
    int[] dimensions = readArrFromConsole(input);
    int[][] matrix = new int[dimensions[0]][dimensions[1]];

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        matrix[row][col] = 0;
      }
    }
    return matrix;
  }

  private static int[] readArrFromConsole(String input) {
    return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
  }
}
