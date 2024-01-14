import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> hashSet = new HashSet<>();
        Set<Person> treeSet = new TreeSet<>();

        int n = scanner.nextInt();
        scanner.nextLine();

        while (n > 0) {
            String input = scanner.nextLine();
            addPersonToSets(hashSet, treeSet, input);
            n--;
        }

        printSetsSizes(hashSet, treeSet);
    }

    private static void printSetsSizes(Set<Person> hashSet, Set<Person> treeSet) {
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }

    private static void addPersonToSets(Set<Person> hashSet, Set<Person> treeSet, String input) {
        String[] tokens = input.split(" ");
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        Person person = new Person(name, age);

        hashSet.add(person);
        treeSet.add(person);
    }
}


