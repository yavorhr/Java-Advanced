import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<Person> comparedyByNames = new TreeSet<>(new ComparatorByName());
        TreeSet<Person> comparedyByAge = new TreeSet<>(new ComparatorByAge());

        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);

            Person person = new Person(name, age);
            comparedyByNames.add(person);
            comparedyByAge.add(person);
        }
        comparedyByNames.forEach(System.out::println);
        comparedyByAge.forEach(System.out::println);
    }
}


