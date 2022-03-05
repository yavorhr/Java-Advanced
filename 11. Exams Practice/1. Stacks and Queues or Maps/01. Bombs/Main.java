import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasingStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombEffectsQueue::offer);
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombCasingStack::push);

        int daturaBombs = 0;
        int cherryBomb = 0;
        int smokeDecoyBomb = 0;

        boolean bombIsMade = false;

        while (!bombCasingStack.isEmpty() && !bombEffectsQueue.isEmpty()) {

            int effect = bombEffectsQueue.peek();
            int casing = bombCasingStack.peek();
            int combineResult = effect + casing;

            switch (combineResult) {
                case 40:
                    daturaBombs++;
                    bombCasingStack.pop();
                    bombEffectsQueue.poll();
                    break;
                case 60:
                    cherryBomb++;
                    bombCasingStack.pop();
                    bombEffectsQueue.poll();
                    break;
                case 120:
                    smokeDecoyBomb++;
                    bombCasingStack.pop();
                    bombEffectsQueue.poll();
                    break;
                default:
                    int numToRemove = bombCasingStack.pop();
                    int numToInsert = numToRemove - 5;
                    bombCasingStack.push(numToInsert);
            }

            if (daturaBombs >= 3 && cherryBomb >= 3 && smokeDecoyBomb >= 3) {
                bombIsMade = true;
                break;
            }
        }

        if (!bombIsMade) {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        } else {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }

        if (bombEffectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            StringBuilder sbQueue = new StringBuilder();
            sbQueue.append("Bomb Effects: ");
            while (bombEffectsQueue.size() > 1) {
                sbQueue.append(bombEffectsQueue.poll() + ", ");
            }
            sbQueue.append(bombEffectsQueue.poll());
            System.out.println(sbQueue.toString());
        }

        if (bombCasingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            StringBuilder sbStack = new StringBuilder();
            sbStack.append("Bomb Casings: ");
            while (bombCasingStack.size() > 1) {
                sbStack.append(bombCasingStack.pop() + ", ");
            }
            sbStack.append(bombCasingStack.pop());
            System.out.println(sbStack.toString());
        }

        System.out.println(String.format("Cherry Bombs: %d", cherryBomb));
        System.out.println(String.format("Datura Bombs: %d", daturaBombs));
        System.out.println(String.format("Smoke Decoy Bombs: %d", smokeDecoyBomb));

    }
}
