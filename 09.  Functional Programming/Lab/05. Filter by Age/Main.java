import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", this.name, this.age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            people.add(new Person(name, age));
        }

        String criteria = scanner.nextLine();
        int ageCriteria = Integer.parseInt(scanner.nextLine());
        String formatOption = scanner.nextLine();

        Predicate<Person> ageFilter = createFilterPredicate(criteria, ageCriteria);
        Function<Person, String> formatter = createFormatter(formatOption);

        String output = people
                .stream()
                .filter(ageFilter)
                .map(formatter)
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(output);
    }

    public static Predicate<Person> createFilterPredicate(String criteria, int ageCriteria) {
        if (criteria.equals("older")) {
            return p -> p.age >= ageCriteria;
        }
        return p -> p.age <= ageCriteria;
    }

    public static Function<Person, String> createFormatter(String formatOption) {
        if (formatOption.equals("name")) {
            return p -> p.name;
        } else if (formatOption.equals("age")) {
            return p -> String.valueOf(p.age);
        }
        return Person::toString;
    }
}




