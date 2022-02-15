import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damage = Double.parseDouble(scanner.nextLine());
        int playerHealth = 18500;
        double bossHealth = 3000000;

        int[] playerPos = new int[2];
        playerPos[0] = 7;
        playerPos[1] = 7;

        String lastSpell = "";
        boolean isInCloud = false;
        while (playerHealth > 0) {
            bossHealth -= damage;

            if (bossHealth <= 0) {
                break;
            }

            String[] tokens = scanner.nextLine().split("\\s+");

            if (isInCloud) {
                playerHealth -= 3500;
                isInCloud = false;
            }

            if (playerHealth <= 0) {
                lastSpell = "Cloud";
                break;
            }

            String spell = tokens[0];
            int targetRow = Integer.parseInt(tokens[1]);
            int targetCol = Integer.parseInt(tokens[2]);
            lastSpell = spell;

            boolean isPlayerDamaged = checkPlayerIsHit(playerPos[0], playerPos[1], targetRow, targetCol);

            int damageDone = 0;
            if (isPlayerDamaged) {
                if (spell.equals("Cloud")) {
                    damageDone = 3500;
                } else {
                    damageDone = 6000;
                }

                boolean canMove = playerCanMoveAndMovePlayer(playerPos, targetRow, targetCol);

                if (!canMove) {
                    playerHealth -= damageDone;
                    if (spell.equals("Cloud")) {
                        isInCloud = true;
                    }
                }
            }
        }
        if (bossHealth > 0) {
            System.out.printf("Heigan: %.2f%n", bossHealth);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHealth <= 0) {
            lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : lastSpell;
            System.out.printf("Player: Killed by %s%n", lastSpell);
        } else {
            System.out.printf("Player: %d%n", playerHealth);
        }
        System.out.println(String.format("Final position: %d, %d", playerPos[0], playerPos[1]));
    }

    private static boolean playerCanMoveAndMovePlayer(int[] position, int targetRow, int targetCol) {

        boolean canMove = false;
        //Up Right Down Left

        int r = position[0];
        int c = position[1];

        if (isInBounds(r - 1, c) && !checkPlayerIsHit(r - 1, c, targetRow, targetCol)) {
            r--;
            canMove = true;
        } else if (isInBounds(r, c + 1) && !checkPlayerIsHit(r, c + 1, targetRow, targetCol)) {
            c++;
            canMove = true;
        } else if (isInBounds(r + 1, c) && !checkPlayerIsHit(r + 1, c + 1, targetRow, targetCol)) {
            r++;
            canMove = true;
        } else if (isInBounds(r, c - 1) && !checkPlayerIsHit(r, c - 1, targetRow, targetCol)) {
            c--;
            canMove = true;
        }

        position[0] = r;
        position[1] = c;
        return canMove;
    }

    private static boolean isInBounds(int r, int c) {
        return r >= 0 && r < 15 && c >= 0 && c < 15;
    }


    private static boolean checkPlayerIsHit(int playerRow, int playerCol, int targetRow, int targetCol) {
        return playerRow >= targetRow - 1 && playerRow <= targetRow + 1
                && playerCol >= targetCol - 1 && playerCol <= targetCol + 1;
    }
}












