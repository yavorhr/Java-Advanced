import java.util.Scanner;

public class Main {
    static boolean reachFinal = false;
    static int currentRow = -1;
    static int currentCol = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        int[] playerPosition = new int[2];
        char[][] matrix = fillMatrix(scanner, playerPosition, size);

        while (n-- > 0 || !reachFinal) {
            String direction = scanner.nextLine();



            switch (direction) {
                case "down" -> movePlayer(currentRow + 1, currentCol, playerPosition, matrix, "down");
                case "up" -> movePlayer(currentRow - 1, currentCol, playerPosition, matrix, "up");
                case "left" -> movePlayer(currentRow, currentCol - 1, playerPosition, matrix, "left");
                case "right" -> movePlayer(currentRow, currentCol + 1, playerPosition, matrix, "right");
            }
        }
    }

    private static void movePlayer(int row, int col, int[] playerPosition, char[][] matrix, String direction) {
        char currentChar = matrix[row][col];

        if (!isInBounds(row, col, matrix)) {
        }

        if (currentChar == 'F') {
            reachFinal = true;
        } else if (currentChar == 'B') {
            playerSteppedOnBonus();
        } else if (currentChar == 'T') {
            playerSteppedOnTrap();
        }
        matrix[row][col] = 'f';
        matrix[playerPosition[0]][playerPosition[1]] = '-';
        playerPosition[0] = row;
        playerPosition[1] = col;

    }

    private static char movePlayerAtTheOtherSideOfTheMatrix(char[][] matrix, int[] playerPosition, String direction) {
        int currentRow = playerPosition[0];
        int currentCol = playerPosition[1];

        switch (direction) {
            case "down" -> {
                playerPosition[0] = matrix[0][currentCol];
                matrix[0][currentCol] = 'f';
                matrix[currentRow][currentCol] = ' ';
            }
            case "up" ->
            case "left" ->
            case "right" ->
        }
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static char[][] initMatrix(String input) {
        int size = Integer.parseInt(input);
        return new char[size][size];
    }

    private static char[][] fillMatrix(Scanner scanner, int[] playerPosition, int size) {
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            if (line.contains("f")) {
                playerPosition[0] = row;
                playerPosition[1] = line.indexOf('f');

                currentRow = row;
                currentCol = line.indexOf('f');
            }
            matrix[row] = line.replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
