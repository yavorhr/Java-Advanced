import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] info = input.split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            String town = info[2];
            Person person = new Person(name, age, town);
            people.add(person);
            input = scanner.nextLine();
        }

        int n = Integer.parseInt(scanner.nextLine());
        Person personForCompare = people.get(n - 1);

        int countEqual = 0;
        for (Person person : people) {
            if (personForCompare.compareTo(person) == 0) {
                countEqual++;
            }
        }

        if (countEqual == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(countEqual + " " + (people.size()  - countEqual) + " " +people.size());
        }
    }
}


