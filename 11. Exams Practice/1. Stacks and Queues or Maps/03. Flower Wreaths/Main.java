import java.util.ArrayDeque;
import java.util.Arrays;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(liliesStack::push);
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(rosesQueue::offer);

        int flowersRest = 0;
        int wreaths = 0;

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int lilly = liliesStack.peek(); //13
            int rose = rosesQueue.peek();   //2
            int result = lilly + rose;

            if (result == 15) {
                wreaths++;
                liliesStack.pop();
                rosesQueue.poll();
            } else if (result > 15) {
                int num = liliesStack.pop();
                int numToAdd = num - 2;
                liliesStack.push(numToAdd);
            } else {
                int flowersToStore = liliesStack.pop() + rosesQueue.poll();
                flowersRest += flowersToStore;
            }
        }

        int additionalWreaths = flowersRest / 15;
        wreaths += additionalWreaths;

        if (wreaths >= 5) {
            System.out.println(String.format("You made it, you are going to the competition with %d wreaths!",wreaths));
        } else {
            int notEnoughWreaths = 5-wreaths;
            System.out.println(String.format("You didn't make it, you need %d wreaths more!",notEnoughWreaths));
        }
        
    }
}
