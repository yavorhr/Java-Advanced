import java.util.Scanner;

public class Main {
    public static int foodCount = 0;
    public static int snakeRow = 0;
    public static int snakeCol = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            if (line.contains("S")) {
                snakeRow = row;
            }
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'S') {
                    snakeCol = col;
                }
            }
        }

        boolean outOfBounds = false;
        while (foodCount < 10) {
            String command = scanner.nextLine();
            if (command.equals("up")) {
                if (outOfBounds(snakeRow - 1, snakeCol, matrix)) {
                    outOfBounds = true;
                    matrix[snakeRow] [snakeCol] = '.';
                    break;
                } else {
                    movePlayer(snakeRow - 1, snakeCol, matrix);
                }
            } else if (command.equals("down")) {
                if (outOfBounds(snakeRow + 1, snakeCol, matrix)) {
                    outOfBounds = true;
                    matrix[snakeRow] [snakeCol] = '.';
                    break;
                } else {
                    movePlayer(snakeRow + 1, snakeCol, matrix);
                }
            } else if (command.equals("left")) {
                if (outOfBounds(snakeRow, snakeCol - 1, matrix)) {
                    matrix[snakeRow] [snakeCol] = '.';
                    outOfBounds = true;
                    break;
                } else {
                    movePlayer(snakeRow, snakeCol - 1, matrix);
                }
            } else if (command.equals("right")) {
                if (outOfBounds(snakeRow, snakeCol + 1, matrix)) {
                    matrix[snakeRow] [snakeCol] = '.';
                    outOfBounds = true;
                    break;
                } else {
                    movePlayer(snakeRow, snakeCol + 1, matrix);
                }
            }
        }

        if (outOfBounds) {
            System.out.println("Game over!");
        }

        if (foodCount == 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", foodCount);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    private static void movePlayer(int newRow, int newCol, char[][] matrix) {
        matrix[snakeRow][snakeCol] = '.';
        if (matrix[newRow][newCol] == '-') {
            matrix[newRow][newCol] = 'S';
            snakeRow = newRow;
            snakeCol = newCol;
        } else if (matrix[newRow][newCol] == '*') {
            foodCount++;
            matrix[newRow][newCol] = 'S';
            snakeRow = newRow;
            snakeCol = newCol;
        } else if (matrix[newRow][newCol] == 'B') {
            matrix[newRow][newCol] = '.';
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 'B' && matrix[row] != matrix[newRow]) {
                        matrix[row][col] = 'S';
                        snakeRow = row;
                        snakeCol = col;
                    }
                }
            }

        }
    }

    private static boolean outOfBounds(int newRol, int newCol, char[][] matrix) {
        return newRol < 0 || newRol >= matrix.length || newCol < 0 || newCol >= matrix.length;
    }
}


