import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> veggies = new LinkedHashMap<String, Integer>() {{
            put("tomato", 80);
            put("carrot", 136);
            put("lettuce", 109);
            put("potato", 215);
        }};

        ArrayDeque<Integer> saladsCal = new ArrayDeque<>();
        ArrayDeque<String> vegetables = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(vegetables::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(saladsCal::push);

        while (!vegetables.isEmpty() && !saladsCal.isEmpty()) {
            int currentSalad = saladsCal.peek();

            while (currentSalad > 0 && !vegetables.isEmpty()) {
                currentSalad -= veggies.get(vegetables.poll());
            }

            System.out.print(saladsCal.pop() + " ");
        }
        System.out.println();

        if (!saladsCal.isEmpty()) {
            System.out.println(saladsCal.toString().replaceAll("[\\[\\],]", ""));
        }

        if (!vegetables.isEmpty()) {
            System.out.println(vegetables.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}

