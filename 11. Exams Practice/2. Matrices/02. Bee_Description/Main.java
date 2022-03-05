import java.util.Scanner;

public class Main {
    public static int beeRow = 0;
    public static int beeCol = 0;
    public static int flowers = 0;
    public static boolean gotLost = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            if (line.contains("B")) {
                beeRow = row;
                beeCol = line.indexOf("B");
            }
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line.charAt(col);
            }
        }
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            if (input.equals("up")) {
                moveBeeUp(beeRow - 1, beeCol, matrix);
                if (gotLost) {
                    matrix[beeRow][beeCol] = '.';
                    break;
                }
            } else if (input.equals("down")) {
                moveDown(beeRow + 1, beeCol, matrix);
                if (gotLost) {
                    matrix[beeRow][beeCol] = '.';
                    break;
                }
            } else if (input.equals("right")) {
                moveRight(beeRow, beeCol + 1, matrix);
                if (gotLost) {
                    matrix[beeRow][beeCol] = '.';
                    break;
                }
            } else if (input.equals("left")) {
                moveLeft(beeRow, beeCol - 1, matrix);
                if (gotLost) {
                    matrix[beeRow][beeCol] = '.';
                    break;
                }
            }
            input = scanner.nextLine();
        }

        if (flowers >= 5) {
            System.out.println(String.format("Great job, the bee manage to pollinate %d flowers!", flowers));
        } else {
            System.out.println(String.format("The bee couldn't pollinate the flowers, she needed %d flowers more", 5 - flowers));
        }
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

    private static void moveLeft(int newRow, int newCol, char[][] matrix) {
        if (outSideOfBounds(newRow, newCol, matrix)) {
            System.out.println("The bee got lost!");
            gotLost = true;
            return;
        }
        if (matrix[newRow][newCol] == '.') {
            matrix[newRow][newCol] = 'B';
            matrix[beeRow][beeCol] = '.';
            beeCol = newCol;
        } else if (matrix[newRow][newCol] == 'f') {
            flowers++;
            matrix[beeRow][beeCol] = '.';
            matrix[newRow][newCol] = 'B';
            beeCol = newCol;
        } else if (matrix[newRow][newCol] == 'O') {
            matrix[newRow][newCol] = '.';
            matrix[beeRow][beeCol] = '.';
            beeCol -= 2;
            if (matrix[beeRow][beeCol] == 'f') {
                flowers++;
            }
            matrix[beeRow][beeCol] = 'B';
        }
    }

    private static void moveRight(int newRow, int newCol, char[][] matrix) {
        if (outSideOfBounds(newRow, newCol, matrix)) {
            System.out.println("The bee got lost!");
            gotLost = true;
            return;
        }

        if (matrix[newRow][newCol] == '.') {
            matrix[newRow][newCol] = 'B';
            matrix[beeRow][beeCol] = '.';
            beeCol = newCol;
        } else if (matrix[newRow][newCol] == 'f') {
            flowers++;
            matrix[beeRow][beeCol] = '.';
            matrix[newRow][newCol] = 'B';
            beeCol = newCol;
        } else if (matrix[newRow][newCol] == 'O') {
            matrix[newRow][newCol] = '.';
            matrix[beeRow][beeCol] = '.';
            beeCol += 2;
            if (matrix[beeRow][beeCol] == 'f') {
                flowers++;
            }
            matrix[beeRow][beeCol] = 'B';
        }
    }

    private static void moveDown(int newRow, int newCol, char[][] matrix) {
        if (outSideOfBounds(newRow, newCol, matrix)) {
            System.out.println("The bee got lost!");
            gotLost = true;
            return;
        }

        if (matrix[newRow][newCol] == '.') {
            matrix[newRow][newCol] = 'B';
            matrix[beeRow][beeCol] = '.';
            beeRow = newRow;
        } else if (matrix[newRow][newCol] == 'f') {
            flowers++;
            matrix[beeRow][beeCol] = '.';
            matrix[newRow][newCol] = 'B';
            beeRow = newRow;
        } else if (matrix[newRow][newCol] == 'O') {
            matrix[beeRow][beeCol] = '.';
            matrix[newRow][newCol] = '.';
            beeRow += 2;
            if (matrix[beeRow][beeCol] == 'f') {
                flowers++;
            }
            matrix[beeRow][beeCol] = 'B';
        }
    }


    private static void moveBeeUp(int newRow, int newCol, char[][] matrix) {
        if (outSideOfBounds(newRow, newCol, matrix)) {
            System.out.println("The bee got lost!");
            gotLost = true;
            return;
        }

        if (matrix[newRow][newCol] == '.') {
            matrix[newRow][newCol] = 'B';
            matrix[beeRow][beeCol] = '.';
            beeRow = newRow;
        } else if (matrix[newRow][newCol] == 'f') {
            flowers++;
            matrix[beeRow][beeCol] = '.';
            matrix[newRow][newCol] = 'B';
            beeRow = newRow;
        } else if (matrix[newRow][newCol] == 'O') {
            matrix[newRow][newCol] = '.';
            matrix[beeRow][beeCol] = '.';
            beeRow -= 2;
            if (matrix[beeRow][beeCol] == 'f') {
                flowers++;
            }
            matrix[beeRow][beeCol] = 'B';
        }
    }

    private static boolean outSideOfBounds(int newRol, int newCol, char[][] matrix) {
        return newRol < 0 || newRol >= matrix.length || newCol < 0 || newCol >= matrix.length;
    }
}








