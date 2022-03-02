import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordsWithUpperCase = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(w -> Character.isUpperCase(w.charAt(0)))
                .collect(Collectors.toList());

        System.out.println(wordsWithUpperCase.size());

        System.out.println(wordsWithUpperCase.stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }
}

