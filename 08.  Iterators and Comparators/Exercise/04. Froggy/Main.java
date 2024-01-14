import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers =
                Arrays.stream(scanner.nextLine()
                        .split(", "))
                        .mapToInt(Integer::parseInt).toArray();

        Lake lake = new Lake(numbers);

        Iterator<Integer> iterator = lake.iterator();

        printResult(iterator);
    }

    private static void printResult(Iterator<Integer> iterator) {
        StringBuilder result = new StringBuilder();

        while (iterator.hasNext()) {
            result.append(String.format("%d, ", iterator.next()));
        }

        System.out.println(result.substring(0, result.toString().lastIndexOf(", ")));
    }
}



