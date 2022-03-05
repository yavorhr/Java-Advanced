import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> boxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> boxStack = new ArrayDeque<>();

        int claimedItems = 0;
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(boxQueue::offer);
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < nums.length; i++) {
            boxStack.push(nums[i]);
        }

        while (!boxStack.isEmpty() && !boxQueue.isEmpty()) {
            int sum = boxStack.peek() + boxQueue.peek();
            if (sum % 2 == 0) {
                claimedItems += sum;
                boxQueue.pop();
                boxStack.poll();
            } else {
                int number = boxStack.pop();
                boxQueue.offer(number);
            }
        }

        if (boxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (claimedItems >= 100) {
            System.out.println(String.format("Your loot was epic! Value: %d",claimedItems));
        } else {
            System.out.println(String.format("Your loot was poor... Value: %d",claimedItems));
        }
    }
}



