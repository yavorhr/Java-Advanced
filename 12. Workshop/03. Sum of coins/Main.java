import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");

        int[] coins = new int[elements.length];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> result = new LinkedHashMap<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            int currentCoin = coins[i];
            int coinsCount = targetSum / currentCoin;

            if (coinsCount != 0) {
                result.put(currentCoin, coinsCount);
            }
            targetSum = targetSum % currentCoin;

            if (targetSum == 0) {
                break;
            }
        }
        return result;
    }
}