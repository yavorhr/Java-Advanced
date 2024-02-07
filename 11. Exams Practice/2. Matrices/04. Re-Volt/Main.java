import java.util.Scanner;

public class Main {
    static boolean reachFinal = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        int[] playerPosition = new int[2];
        char[][] matrix = fillMatrix(scanner, playerPosition, size);

        while (n-- > 0 || !reachFinal) {
            String direction = scanner.nextLine();

            switch (direction) {
                case "down" -> movePlayer(playerPosition[0] + 1, playerPosition[1], playerPosition, matrix, "down");
                case "up" -> movePlayer(playerPosition[0] - 1, playerPosition[1], playerPosition, matrix, "up");
                case "left" -> movePlayer(playerPosition[0], playerPosition[1] - 1, playerPosition, matrix, "left");
                case "right" -> movePlayer(playerPosition[0], playerPosition[1] + 1, playerPosition, matrix, "right");
            }
        }
    }

    private static void movePlayer(int row, int col, int[] playerPosition, char[][] matrix, String direction) {
        char currentChar = matrix[row][col];

        if (currentChar == 'F') {
            reachFinal = true;
        } else if (currentChar == 'B') {
            movePlayer(row, col, playerPosition, matrix, direction);
        } else if (currentChar == 'T') {
            playerSteppedOnTrap();
        }
        matrix[row][col] = 'f';
        matrix[playerPosition[0]][playerPosition[1]] = '-';
        playerPosition[0] = row;
        playerPosition[1] = col;

    }

    private static void movePlayerOnTheOtherSide(int row, int col, int[] playerPosition, char[][] matrix, String direction) {
        switch (direction) {
            case "down" -> movePlayer(row + 1, col, playerPosition, matrix, direction);
            case "up" -> movePlayer(row - 1, col, playerPosition, matrix, direction);
            case "left" -> movePlayer(row, col - 1, playerPosition, matrix, direction);
            case "right" -> movePlayer(row, col + 1, playerPosition, matrix, direction);
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


            }
            matrix[row] = line.replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }

    private static int moveUp(char[][] matrix, int row) {
        row--;
        if (row < 0) {
            row = matrix.length - 1;
        }
        return row;
    }

    private static int moveDown(char[][] matrix, int row) {
        row++;
        if (row > matrix.length - 1) {
            row = 0;
        }
        return row;
    }

    private static int moveRight(char[][] matrix, int col) {
        col++;
        if (col > matrix[col].length) {
            col = 0;
        }
        return col;
    }


    private static int moveLeft(char[][] matrix, int col) {
        col--;
        if (col < 0) {
            col = matrix[col].length - 1;
        }
        return col;
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
