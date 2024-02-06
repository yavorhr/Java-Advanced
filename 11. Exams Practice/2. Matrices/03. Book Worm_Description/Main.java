import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());
        int[] playerPosition = new int[2];

        char[][] matrix = initMatrix(scanner.nextLine());
        fillMatrix(matrix, scanner, playerPosition);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String direction = input;
            switch (direction) {
                case "down" -> movePlayer(playerPosition[0] + 1, playerPosition[1], playerPosition, matrix, sb);
                case "up" -> movePlayer(playerPosition[0] - 1, playerPosition[1], playerPosition, matrix, sb);
                case "left" -> movePlayer(playerPosition[0], playerPosition[1] - 1, playerPosition, matrix, sb);
                case "right" -> movePlayer(playerPosition[0], playerPosition[1] + 1, playerPosition, matrix, sb);
            }
            input = scanner.nextLine();
        }
        printOutput(sb, matrix);
    }

    private static void movePlayer(int row, int col, int[] playerPosition, char[][] matrix, StringBuilder string) {
        if (!isInBounds(row, col, matrix)) {
            removeLastLetter(string);
            return;
        }

        char currentChar = matrix[row][col];

        if (Character.isLetter(currentChar)) {
            string.append(currentChar);
        }

        matrix[row][col] = 'P';
        matrix[playerPosition[0]][playerPosition[1]] = '-';
        playerPosition[0] = row;
        playerPosition[1] = col;
    }

    private static void removeLastLetter(StringBuilder string) {
        if (!string.isEmpty()) {
            int lastIndex = string.length() - 1;
            string.deleteCharAt(lastIndex);
        }
    }

    private static void printOutput(StringBuilder sb, char[][] matrix) {
        System.out.println(sb);
        printMatrix(matrix);
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static char[][] initMatrix(String input) {
        int size = Integer.parseInt(input);
        return new char[size][size];
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner, int[] playerPosition) {
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            if (line.contains("P")) {
                playerPosition[0] = row;
                playerPosition[1] = line.indexOf('P');
            }
            matrix[row] = line.replaceAll("\\s+", "").toCharArray();
        }
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
