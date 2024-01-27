import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        scanner.nextLine();

        Map<Character, Integer> countOutputs = getHarvestVeggiesOutput();
        char[][] matrix = readMatrix(scanner, rows);

        String input = scanner.nextLine();
        while (!"End of Harvest".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Harvest" -> {
                    if (isInBounds(row, col, matrix) && matrix[row][col] != ' ') {
                        countOutputChars(countOutputs, matrix, row, col);
                    }
                }
                case "Mole" -> {
                    String direction = tokens[3];

                    if (isInBounds(row, col, matrix)) {
                        switch (direction) {
                            case "up" -> moveUp(matrix, row, col, countOutputs);
                            case "down" -> moveDown(matrix, row, col, countOutputs);
                            case "right" -> moveRight(matrix, row, col, countOutputs);
                            case "left" -> moveLeft(matrix, row, col, countOutputs);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        printOutput(matrix, countOutputs);
    }

    private static Map<Character, Integer> getHarvestVeggiesOutput() {
        Map<Character, Integer> countOutputs = new LinkedHashMap<>();
        countOutputs.put('C', 0);
        countOutputs.put('P', 0);
        countOutputs.put('L', 0);
        countOutputs.put(' ', 0);
        return countOutputs;
    }

    private static void printOutput(char[][] matrix, Map<Character, Integer> countOutputs) {
        countOutputs.forEach((key, value) ->
                System.out.printf("%s: %d\n",
                        getVeggieAsString(key), value));

        for (char[] chars : matrix) {
            for (char currentChar : chars) {
                System.out.print(currentChar + " ");
            }
            System.out.println();
        }
    }

    private static String getVeggieAsString(Character key) {
        String veggie = "";

        if (key.equals('L')) {
            veggie = "Lettuce";
        } else if (key.equals('C')) {
            veggie = "Carrots";
        } else if (key.equals('P')) {
            veggie = "Potatoes";
        } else {
            veggie = "Harmed vegetables";
        }
        return veggie;
    }

    private static void moveLeft(char[][] matrix, int row, int col, Map<Character, Integer> countOutputs) {
        for (int i = col; i >= 0; i -= 2) {
            char currentCHar = matrix[row][i];

            if (currentCHar != ' ') {
                matrix[row][i] = ' ';
                countOutputChars(countOutputs, matrix, row, col);
            }
        }
    }

    private static void moveRight(char[][] matrix, int row, int col, Map<Character, Integer> countOutputs) {
        for (int i = col; i < matrix[row].length; i += 2) {
            char currentCHar = matrix[row][i];

            if (currentCHar != ' ') {
                matrix[row][i] = ' ';
                countOutputChars(countOutputs, matrix, row, col);
            }
        }
    }

    private static void moveDown(char[][] matrix, int row, int col, Map<Character, Integer> countOutputs) {
        for (int i = row; i < matrix.length; i += 2) {
            char currentCHar = matrix[i][col];

            if (currentCHar != ' ') {
                matrix[i][col] = ' ';
                countOutputChars(countOutputs, matrix, row, col);
            }
        }
    }

    private static void moveUp(char[][] matrix, int row, int col, Map<Character, Integer> countOutputs) {
        for (int i = row; i >= 0; i -= 2) {
            char currentCHar = matrix[i][col];

            if (currentCHar != ' ') {
                matrix[i][col] = ' ';
                countOutputChars(countOutputs, matrix, row, col);
            }
        }
    }

    private static char[][] readMatrix(Scanner scanner, int rows) {
        char[][] matrix = new char[rows][];

        for (int i = 0; i < matrix.length; i++) {
            char[] col = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();

            matrix[i] = col;
        }
        return matrix;
    }

    private static void countOutputChars(Map<Character, Integer> counterMap, char[][] matrix, int row, int col) {
        char currentVeggieChar = matrix[row][col];
        int increaseCount = counterMap.get(currentVeggieChar) + 1;
        counterMap.put(currentVeggieChar, increaseCount);

        matrix[row][col] = ' ';
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length;
    }
}




