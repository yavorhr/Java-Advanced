import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lettuce = 0;
        int potatoes = 0;
        int carrots = 0;
        int harmedVeggies = 0;

        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        String commands = scanner.nextLine();
        while (!("End of Harvest").equals(commands)) {
            String[] tokens = commands.split("\\s+");
            String currentCommand = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            if (currentCommand.equals("Harvest")) {
                if (inBounds(row, col, matrix)) {
                    if (matrix[row][col] == 'L') {
                        lettuce++;
                    } else if (matrix[row][col] == 'C') {
                        carrots++;
                    } else if (matrix[row][col] == 'P') {
                        potatoes++;
                    }
                    matrix[row][col] = ' ';
                }

            } else if (currentCommand.equals("Mole")) {
                String direction = tokens[3];
                switch (direction) {
                    case "up":
                        if (inBounds(row, col, matrix)) {
                            for (int i = row; i >= 0; i -= 2) {
                                if (matrix[i][col] != ' ') {
                                    harmedVeggies++;
                                    matrix[i][col] = ' ';
                                }
                            }
                        }
                        break;
                    case "down":
                        if (inBounds(row, col, matrix)) {
                            for (int i = row; i <= matrix.length - 1; i += 2) {
                                if (matrix[i][col] != ' ') {
                                    harmedVeggies++;
                                    matrix[i][col] = ' ';
                                }
                            }
                        }
                        break;
                    case "left":
                        if (inBounds(row, col, matrix)) {
                            for (int i = col; i >= 0; i -= 2) {
                                if (matrix[row][i] != ' ') {
                                    harmedVeggies++;
                                    matrix[row][i] = ' ';
                                }
                            }
                        }
                        break;
                    case "right":
                        if (inBounds(row, col, matrix)) {
                            for (int i = col; i <= matrix[row].length - 1; i += 2) {
                                if (matrix[row][i] != ' ') {
                                    harmedVeggies++;
                                    matrix[row][i] = ' ';
                                }
                            }
                        }
                        break;
                }
            }
            commands = scanner.nextLine();
        }

        printMatrix(matrix);
        System.out.println(String.format("Carrots: %d", carrots));
        System.out.println(String.format("Potatoes: %d", potatoes));
        System.out.println(String.format("Lettuce: %d", lettuce));
        System.out.println(String.format("Harmed vegetables: %d", harmedVeggies));
    }

    private static boolean inBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix[row].length - 1;
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







