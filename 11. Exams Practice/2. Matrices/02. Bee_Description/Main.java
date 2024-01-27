import java.util.*;

public class Main {
    public static int beeRow = 0;
    public static int beeCol = 0;
    public static int flowersCount = 0;
    public static int NEEDED_FLOWERS = 5;
    public static boolean isLost = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        char[][] matrix = readMatrix(scanner, n);
        findBeeCoordinates(matrix);

        String moveDirection = scanner.nextLine();
        while (!"End".equals(moveDirection)) {
            moveBee(matrix, moveDirection, beeRow, beeCol);

            if (beeIsLost()) {
                break;
            }
            moveDirection = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void moveBee(char[][] matrix, String moveDirection, int beeRow, int beeCol) {
        switch (moveDirection) {
            case "up" -> moveUp(matrix, beeRow, beeCol);
            case "down" -> moveDown(matrix, beeRow, beeCol);
            case "right" -> moveRight(matrix, beeRow, beeCol);
            case "left" -> moveLeft(matrix, beeRow, beeCol);
        }
    }

    private static void moveLeft(char[][] matrix, int row, int col) {
        matrix[row][col] = '.';
        int newCol = col - 1;
        updateCoordinates(matrix, row, newCol, "left");
    }

    private static void moveRight(char[][] matrix, int row, int col) {
        matrix[row][col] = '.';
        int newCol = col + 1;
        updateCoordinates(matrix, row, newCol, "right");
    }

    private static void moveUp(char[][] matrix, int row, int col) {
        matrix[row][col] = '.';
        int newRow = row - 1;
        updateCoordinates(matrix, newRow, col, "up");
    }

    private static void moveDown(char[][] matrix, int row, int col) {
        matrix[row][col] = '.';
        int newRow = row + 1;
        updateCoordinates(matrix, newRow, col, "down");
    }

    private static void updateCoordinates(char[][] matrix, int row, int col, String direction) {
        if (outsideOfBounds(matrix, row, col)) {
            isLost = true;
        } else if (matrix[row][col] == 'O') {
            extraMoveFromBonus(direction, matrix, row, col);
        } else if (matrix[row][col] == 'f') {
            flowersCount += 1;
            matrix[row][col] = 'B';

            beeRow = row;
            beeCol = col;
        } else {
            matrix[row][col] = 'B';
            beeRow = row;
            beeCol = col;
        }
    }

    private static void extraMoveFromBonus(String direction, char[][] matrix, int row, int col) {
        moveBee(matrix, direction, row, col);
    }

    private static boolean outsideOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void findBeeCoordinates(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                    break;
                }
            }
        }
    }

    private static char[][] readMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];

        for (int i = 0; i < matrix.length; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }

    public static boolean beeIsLost() {
        return isLost;
    }

    private static void printMatrix(char[][] matrix) {
        if (beeIsLost()) {
            System.out.println("The bee got lost!");
        }

        if (flowersCount >= NEEDED_FLOWERS) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", flowersCount);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", NEEDED_FLOWERS - flowersCount);
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}




