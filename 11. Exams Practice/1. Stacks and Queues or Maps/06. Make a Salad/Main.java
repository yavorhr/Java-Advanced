import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vegetablesQueue = readStringDeque(scanner);
        ArrayDeque<Integer> saladsStack = readIntegerDeque(scanner);

        Map<String, Integer> kcalPerVegetable = initMap();

        while (!saladsStack.isEmpty() && !vegetablesQueue.isEmpty()) {
            int currentSaladCal = saladsStack.pop();

            while (currentSaladCal > 0 && !vegetablesQueue.isEmpty()) {
                String currentVegetable = vegetablesQueue.poll();
                currentSaladCal -= kcalPerVegetable.get(currentVegetable);
            }

            System.out.print(currentSaladCal + " ");
        }

        printOutput(vegetablesQueue, saladsStack);
    }

    private static void printOutput(ArrayDeque<String> vegetablesQueue, ArrayDeque<Integer> saladsStack) {
        if (!saladsStack.isEmpty()) {
            System.out.println(saladsStack.toString().replaceAll("[\\[\\],]", ""));
        }

        if (!vegetablesQueue.isEmpty()) {
            System.out.println(vegetablesQueue.toString().replaceAll("[\\[\\],]", ""));
        }
    }

    private static Map<String, Integer> initMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("tomato", 80);
        map.put("carrot", 136);
        map.put("lettuce", 109);
        map.put("potato", 215);

        return map;
    }


    public static ArrayDeque<String> readStringDeque(Scanner scanner) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(deque::offer);

        return deque;
    }

    public static ArrayDeque<Integer> readIntegerDeque(Scanner scanner) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(deque::push);

        return deque;
    }
}
