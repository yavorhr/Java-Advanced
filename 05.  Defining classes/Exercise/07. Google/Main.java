import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personsMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            String name = tokens[0];
            String criteria = tokens[1];

            personsMap.putIfAbsent(name, new Person(name));
            Person person = personsMap.get(name);

            Object object = getObject(criteria, tokens);
            addClassToPerson(person, object);

            personsMap.put(name, person);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        System.out.println(personsMap.get(input).toString());
    }

    private static void addClassToPerson(Person person, Object object) {
        String string = object.getClass().toString();

        switch (string) {
            case "class Company" -> person.setCompany((Company) object);
            case "class Car" -> person.setCar((Car) object);
            case "class Pokemon" -> person.getPokemons().add((Pokemon) object);
            case "class Parent" -> person.getParents().add((Parent) object);
            case "class Child" -> person.getChildren().add((Child) object);
        }
    }

    private static Object getObject(String criteria, String[] tokens) {
        Object object = null;

        switch (criteria) {
            case "company" -> {
                String name = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                object = new Company(name, department, salary);
            }
            case "pokemon" -> {
                String name = tokens[2];
                String type = tokens[3];

                object = new Pokemon(name, type);
            }
            case "parents" -> {
                String name = tokens[2];
                String birthday = tokens[3];
                object = new Parent(name, birthday);
            }
            case "children" -> {
                String name = tokens[2];
                String birthday = tokens[3];
                object = new Child(name, birthday);
            }
            case "car" -> {
                String model = tokens[2];
                int speed = Integer.parseInt(tokens[3]);
                object = new Car(model, speed);
            }
        }
        return object;
    }
}


