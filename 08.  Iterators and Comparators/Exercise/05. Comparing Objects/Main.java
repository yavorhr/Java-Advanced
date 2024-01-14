import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(" ");

            addPerson(people, tokens);
            input = scanner.nextLine();
        }

        int nthPerson = Integer.parseInt(scanner.nextLine());
        Person personToCompare = people.get(nthPerson - 1);

        int equalPersonsCount = getEqualPersonsCount(people, personToCompare);

        printResult(people, equalPersonsCount);
    }

    private static void printResult(List<Person> people, int equalPersonsCount) {
        if (equalPersonsCount == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equalPersonsCount, people.size() - equalPersonsCount, people.size());
        }
    }

    private static int getEqualPersonsCount(List<Person> people, Person personToCompare) {
        int equalPersonsCount = 0;

        for (Person currentPerson : people) {
            if (currentPerson != personToCompare && currentPerson.compareTo(personToCompare) == 0) {
                equalPersonsCount += 2;
            }
        }
        return equalPersonsCount;
    }

    private static void addPerson(List<Person> people, String[] tokens) {
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String town = tokens[2];

        people.add(new Person(name, age, town));
    }
}



