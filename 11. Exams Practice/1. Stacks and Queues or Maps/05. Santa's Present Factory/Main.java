import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final int DOLL_VALUE = 150;
    private static final int TRAIN_VALUE = 250;
    private static final int TEDDY_BEAR_VALUE = 300;
    private static final int BICYCLE_VALUE = 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialsStack = readDeque(scanner, "stack");
        ArrayDeque<Integer> magicLevelQueue = readDeque(scanner, "queue");
        Map<String, Integer> presentsCount = new HashMap<>();

        while (!materialsStack.isEmpty() && !magicLevelQueue.isEmpty()) {
            int magicValue = magicLevelQueue.peek();
            int materialValue = materialsStack.peek();

            int result = magicValue * materialValue;

            if (craftIsPossible(result)) {
                craftPresents(result, materialsStack, magicLevelQueue, presentsCount);
            } else if (equalToZero(magicValue)) {
                magicLevelQueue.poll();
            } else if (equalToZero(materialValue)) {
                materialsStack.pop();
            } else if (result < 0) {
                removeBothValues(materialsStack, magicLevelQueue);
                int sum = magicValue + materialValue;
                materialsStack.push(sum);
            } else {
                removeBothValues(materialsStack, magicLevelQueue);
                materialsStack.push(materialValue + 15);
            }
        }

        printResult(materialsStack, magicLevelQueue, presentsCount);
    }

    private static void printResult(ArrayDeque<Integer> stack, ArrayDeque<Integer> queue, Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();

        if (pairIsCrafted(map)) {
            sb.append("The presents are crafted! Merry Christmas!\n");
        } else {
            sb.append("No presents this Christmas!\n");
        }

        if (!stack.isEmpty()) {
            sb.append(String.format("Materials left: %s\n", getMaterials(stack)));
        }

        if (!queue.isEmpty()) {
            sb.append(String.format("Materials left: %s\n", getMaterials(queue)));
        }

        map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() != 0)
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .forEach(e ->
                        sb.append(String.format("%s: %d\n", e.getKey(), e.getValue())));

        System.out.println(sb);
    }

    private static String getMaterials(ArrayDeque<Integer> deque) {
        return deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    private static boolean pairIsCrafted(Map<String, Integer> map) {
        return (map.get("Doll") != null && map.get("Train") != null) || (map.get("Teddy bear") != null && map.get("Bicycle") != null);
    }

    private static boolean equalToZero(int value) {
        return value == 0;
    }

    private static boolean craftIsPossible(int result) {
        return result == DOLL_VALUE || result == TRAIN_VALUE || result == TEDDY_BEAR_VALUE || result == BICYCLE_VALUE;
    }

    private static void craftPresents(int result, ArrayDeque<Integer> stack, ArrayDeque<Integer> queue, Map<String, Integer> map) {
        switch (result) {
            case DOLL_VALUE -> addToMap("Doll", map);
            case TRAIN_VALUE -> addToMap("Train", map);
            case TEDDY_BEAR_VALUE -> addToMap("Teddy bear", map);
            case BICYCLE_VALUE -> addToMap("Bicycle", map);
        }

        removeBothValues(stack, queue);
    }

    private static void addToMap(String key, Map<String, Integer> map) {
        map.putIfAbsent(key, 0);
        int incrementCount = map.get(key) + 1;
        map.put(key, incrementCount);
    }

    public static ArrayDeque<Integer> readDeque(Scanner scanner, String type) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        if (type.equals("stack")) {
            Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(deque::push);
        } else {
            Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(deque::offer);
        }
        return deque;
    }

    private static void removeBothValues(ArrayDeque<Integer> stack, ArrayDeque<Integer> queue) {
        stack.pop();
        queue.poll();
    }
}
