import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> chemicalElements = new TreeSet<>();
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String[] components = scanner.nextLine().split("\\s+");
            chemicalElements.addAll(Arrays.asList(components));
        }

        System.out.println(String.join(" ",chemicalElements));
    }
}














