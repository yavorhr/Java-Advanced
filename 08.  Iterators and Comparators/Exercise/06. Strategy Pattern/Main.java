import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> sortedByNameLength = new TreeSet<>(new ComparatorByLengthName());
        TreeSet<Person> sortedByAge = new TreeSet<>(new ComparatorByAge());

        int n = scanner.nextInt();
        scanner.nextLine();

        while (n > 0) {
            String input = scanner.nextLine();
            addPersonToSets(sortedByNameLength, sortedByAge, input);
            n--;
        }

        String result = getPrintResult(sortedByNameLength, sortedByAge);
        System.out.println(result);
    }

    private static String getPrintResult(TreeSet<Person> sortedByNameLength, TreeSet<Person> sortedByAge) {
        return String.format("Sorted by the length of name:\n%s\nSorted by age:\n%s", getPeopleAsString(sortedByNameLength), getPeopleAsString(sortedByAge));
    }

    private static void addPersonToSets(TreeSet<Person> sortedByNameLength, TreeSet<Person> sortedByAge, String input) {
        String[] tokens = input.split(" ");
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        Person person = new Person(name, age);

        sortedByNameLength.add(person);
        sortedByAge.add(person);
    }

    private static String getPeopleAsString(TreeSet<Person> people) {
        StringBuilder sb = new StringBuilder();
        people.forEach(sb::append);
        return sb.toString();
    }
}



