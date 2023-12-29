import java.util.*;

public class Main {
    private static final int MAX_AGE = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        List<Person> peopleList = new ArrayList<>();

        while (n > 0) {

            addPersonToList(scanner, peopleList);

            n--;
        }

        printPeopleOver30years(peopleList);
    }

    private static void printPeopleOver30years(List<Person> peopleList) {
        peopleList
                .stream()
                .filter(p -> p.getAge() > 30)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.printf("%s - %d\n", p.getName(), p.getAge()));
    }

    private static void addPersonToList(Scanner scanner, List<Person> peopleList) {
        String[] tokens = scanner.nextLine().split(" ");
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);

        peopleList.add(new Person(name, age));
    }
}

