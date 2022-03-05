import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicLevelQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(materialStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(magicLevelQueue::offer);

        int doll = 0;
        int woodenTrain = 0;
        int teddyBear = 0;
        int bicycle = 0;

        while (!materialStack.isEmpty() && !magicLevelQueue.isEmpty()) {
            int multiplication = materialStack.peek() * magicLevelQueue.peek();
            switch (multiplication) {
                case 150:
                    doll++;
                    magicLevelQueue.poll();
                    materialStack.pop();
                    break;
                case 250:
                    woodenTrain++;
                    magicLevelQueue.poll();
                    materialStack.pop();
                    break;
                case 300:
                    teddyBear++;
                    magicLevelQueue.poll();
                    materialStack.pop();
                    break;
                case 400:
                    bicycle++;
                    magicLevelQueue.poll();
                    materialStack.pop();
                    break;
                default:
                    if (multiplication < 0) {
                        int sum = materialStack.peek() + magicLevelQueue.peek();
                        magicLevelQueue.poll();
                        materialStack.pop();
                        materialStack.push(sum);
                    } else if (multiplication > 0) {
                        magicLevelQueue.poll();
                        int number = materialStack.pop();
                        materialStack.push(number + 15);
                    } else {
                        if (materialStack.peek() == 0) {
                            materialStack.pop();
                        }
                        if (!magicLevelQueue.isEmpty()) {
                            if (magicLevelQueue.peek() == 0) {
                                magicLevelQueue.poll();
                            }
                        }
                    }
            }
        }

        boolean craftsAreMade = crafts(teddyBear, bicycle, doll, woodenTrain);

        if (craftsAreMade) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }


        if (!materialStack.isEmpty()) {
            System.out.print("Materials left: ");
            while (materialStack.size() > 1) {
                System.out.print(materialStack.poll() + ", ");
            }
            System.out.print(materialStack.poll());
            System.out.println();
        }

        if (!magicLevelQueue.isEmpty()) {
            System.out.print("Magic left: ");
            while (magicLevelQueue.size() > 1) {
                System.out.print(magicLevelQueue.poll() + ", ");
            }
            System.out.print(magicLevelQueue.poll());
            System.out.println();
        }

        if (greaterThanOne(bicycle)) {
            System.out.println(String.format("Bicycle: %d", bicycle));
        }
        if (greaterThanOne(doll)) {
            System.out.println(String.format("Doll: %d", doll));
        }

        if (greaterThanOne(teddyBear)) {
            System.out.println(String.format("Teddy bear: %d", teddyBear));
        }

        if (greaterThanOne(woodenTrain)) {
            System.out.println(String.format("Wooden train: %d", woodenTrain));
        }
    }

    private static boolean greaterThanOne(int num) {
        if (num > 0) {
            return true;
        }
        return false;
    }

    private static boolean crafts(int teddyBear, int bike, int doll, int train) {
        if (teddyBear >= 1 && bike >= 1 || doll >= 1 && train >= 1) {
            return true;
        }
        return false;
    }
}
