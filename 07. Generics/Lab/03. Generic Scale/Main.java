import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> scaleInts = new Scale<>(50, 60);
        Scale<String> scaleString = new Scale<>("50", "600");
        Scale<Character> scaleCharacters = new Scale<>('8', '9');

        System.out.println(scaleInts.getHeavier());
        System.out.println(scaleString.getHeavier());
        System.out.println(scaleCharacters.getHeavier());

        Person person = new Person("Todor", 200);
        Person otherPerson = new Person("Momchil", 300);

        Scale<Person> scalePerson = new Scale<>(person ,otherPerson);
        System.out.printf("Heavier person is : %s", scalePerson.getHeavier());
    }
}

