import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int allPresents = Integer.parseInt(scanner.nextLine()); //5
        int size = Integer.parseInt(scanner.nextLine());
        int rowSanta = 0;
        int colSanta = 0;
        int niceKidsWithoutPresents = 0;    //2
        int countKidsWithPresent = 0;

        char[][] neighborhood = new char[size][size];
        for (int row = 0; row < neighborhood.length; row++) {
            String line = scanner.nextLine();
            line = line.replaceAll(" ", "");
            if (line.contains("S")) {
                rowSanta = row;
                colSanta = line.indexOf("S");
            }
            for (int col = 0; col < neighborhood[row].length; col++) {
                neighborhood[row][col] = line.charAt(col);
                if (neighborhood[row][col] == 'V') {
                    niceKidsWithoutPresents++;
                }
            }
        }
        String input = scanner.nextLine();
        while (!"Christmas morning".equals(input) && allPresents > 0) {
            switch (input) {
                case "up":
                    neighborhood[rowSanta][colSanta] = '-';
                    rowSanta--;
                    break;
                case "down":
                    neighborhood[rowSanta][colSanta] = '-';
                    rowSanta++;
                    break;
                case "left":
                    neighborhood[rowSanta][colSanta] = '-';
                    colSanta--;
                    break;
                case "right":
                    neighborhood[rowSanta][colSanta] = '-';
                    colSanta++;
                    break;
            }

            if (outOfBound(rowSanta, colSanta, neighborhood)) {
                System.out.println("Santa ran out of allPresents.");
                break;
            }

            if (neighborhood[rowSanta][colSanta] == 'V') {
                allPresents--;
                countKidsWithPresent++;
                neighborhood[rowSanta][colSanta] = 'S';
            } else if (neighborhood[rowSanta][colSanta] == 'X' || (neighborhood[rowSanta][colSanta] == '-')) {
                neighborhood[rowSanta][colSanta] = 'S';
            } else if (neighborhood[rowSanta][colSanta] == 'C') {
                neighborhood[rowSanta][colSanta] = 'S';
                //up
                if (neighborhood[rowSanta - 1][colSanta] != '-') {
                    if (neighborhood[rowSanta - 1][colSanta] == 'V') {
                        allPresents--;
                        countKidsWithPresent++;
                        neighborhood[rowSanta - 1][colSanta] = '-';
                    } else if (neighborhood[rowSanta - 1][colSanta] == 'X') {
                        neighborhood[rowSanta - 1][colSanta] = '-';
                        allPresents--;
                    }
                } //down
                if (neighborhood[rowSanta + 1][colSanta] != '-') {
                    if (neighborhood[rowSanta + 1][colSanta] == 'V') {
                        allPresents--;
                        countKidsWithPresent++;
                        neighborhood[rowSanta + 1][colSanta] = '-';
                    } else if (neighborhood[rowSanta + 1][colSanta] == 'X') {
                        neighborhood[rowSanta + 1][colSanta] = '-';
                        allPresents--;
                    }
                } //right
                if (neighborhood[rowSanta][colSanta + 1] != '-') {
                    if (neighborhood[rowSanta][colSanta + 1] == 'V') {
                        allPresents--;
                        countKidsWithPresent++;
                        neighborhood[rowSanta][colSanta + 1] = '-';
                    } else if (neighborhood[rowSanta][colSanta + 1] == 'X') {
                        neighborhood[rowSanta][colSanta + 1] = '-';
                        allPresents--;
                    }
                }
                //left
                if (neighborhood[rowSanta][colSanta - 1] != '-') {
                    if (neighborhood[rowSanta][colSanta - 1] == 'V') {
                        allPresents--;
                        countKidsWithPresent++;
                        neighborhood[rowSanta][colSanta - 1] = '-';
                    } else if (neighborhood[rowSanta][colSanta - 1] == 'X') {
                        neighborhood[rowSanta][colSanta - 1] = '-';
                        allPresents--;
                    }
                }
                if (countKidsWithPresent >= niceKidsWithoutPresents) {
                    break;
                }

                if (allPresents == 0) {
                    System.out.println("Santa ran out of presents!");
                    break;
                }
            }
            if (allPresents == 0) {
                System.out.println("Santa ran out of presents!");
                break;
            }
            if (countKidsWithPresent >= niceKidsWithoutPresents) {
                break;
            }
            input = scanner.nextLine();
        }

        printMatrix(neighborhood);
        if (niceKidsWithoutPresents - countKidsWithPresent == 0) {
            System.out.println(String.format("Good job, Santa! %d happy nice kid/s.", countKidsWithPresent++));
        } else {
            System.out.println(String.format("No presents for %d nice kid/s.", niceKidsWithoutPresents - countKidsWithPresent));
        }
    }

    private static void printMatrix(char[][] neighborhood) {
        for (int row = 0; row < neighborhood.length; row++) {
            for (int col = 0; col < neighborhood[row].length; col++) {
                System.out.print(neighborhood[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean outOfBound(int rowSanta, int colSanta, char[][] neighborhood) {
        return rowSanta < 0 || rowSanta >= neighborhood.length || colSanta < 0 || colSanta >= neighborhood.length;
    }
}




