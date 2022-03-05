import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialText = scanner.nextLine();
        StringBuilder textSb = new StringBuilder(initialText);

        int size = Integer.parseInt(scanner.nextLine());
        int[] playerPosition = new int[2];

        char[][] field = readMatrix(scanner, size, playerPosition);

        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            switch (command) {
                case "up":
                    movePlayer(playerPosition[0] - 1, playerPosition[1], playerPosition, field, textSb);
                    break;
                case "down":
                    movePlayer(playerPosition[0] + 1, playerPosition[1], playerPosition, field, textSb);
                    break;
                case "right":
                    movePlayer(playerPosition[0], playerPosition[1] + 1, playerPosition, field, textSb);
                    break;
                case "left":
                    movePlayer(playerPosition[0], playerPosition[1] - 1, playerPosition, field, textSb);
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println(textSb.toString());
        printMatrix(field);
    }

    private static void printMatrix(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }

    private static void movePlayer(int newRow, int newCol, int[] position, char[][] field, StringBuilder textSb) {
        if (outOfBounds(newRow, newCol, field)) {
            if (!textSb.toString().isEmpty()) {
                int lastIndex = textSb.toString().length() - 1;
                textSb.deleteCharAt(lastIndex);
                return;
            }
        }

        if (field[newRow][newCol] != '-') {
            textSb.append(field[newRow][newCol]);
        }

        field[position[0]][position[1]] = '-';
        field[newRow][newCol] = 'P';

        position[0] = newRow;
        position[1] = newCol;
    }

    private static boolean outOfBounds(int row, int col, char[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static char[][] readMatrix(Scanner scanner, int size, int[] playerPosition) {
        char[][] matrix = new char[size][size];
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            if (line.contains("P")) {
                playerPosition[0] = row;
            }
            for (int col = 0; col < matrix[row].length; col++) {
                if (line.charAt(col) == 'P') {
                    playerPosition[1] = col;
                }
                matrix[row][col] = line.charAt(col);
            }
        }
        return matrix;
    }
}





