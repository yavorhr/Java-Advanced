import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1)
                .collect(Collectors.toCollection(ArrayList::new));

        ListyIterator listyIterator = new ListyIterator(data);
        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            switch (command) {
                case "Create":
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    System.out.println(listyIterator.print());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.iterator().hasNext());
                    break;
                case "PrintAll":
                    listyIterator.forEach(s -> System.out.println(s + " "));
                    break;
            }
            command = scanner.nextLine();
        }


    }
}


