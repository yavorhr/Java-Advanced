import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine();
        int angle = Integer.parseInt(rotation.split("[()]+")[1]) % 360;

        ArrayList<String> linesForMatrix = new ArrayList<String>();

        int maxLength = Integer.MIN_VALUE;

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            linesForMatrix.add(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            input = scanner.nextLine();
        }

        int rows = linesForMatrix.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //ако номерът на колоната е по-малък от дължината на думата (от 0 индекс на листа)...
                if (col < linesForMatrix.get(row).length()) {
                    //...ми дай символът, който е на индекс "col"
                    matrix[row][col] = linesForMatrix.get(row).charAt(col);
                    //за да избегнем "nullPointerException" слагаме празен char ' '.
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        rotate(angle, rows, cols, matrix);
    }

    private static void rotate(int angle, int rows, int cols, char[][] matrix) {
        if (angle == 90) {
            //Редовете ни стават колони
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angle == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angle == 270) {
            //
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }

    }
}









