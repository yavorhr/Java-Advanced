package Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];

            Person person = new Person(name);

            boolean hasPerson = false;
            for (Person currentPerson : people) {
                if (currentPerson.getName().equals(name)) {
                    hasPerson = true;
                    person = currentPerson;
                    break;
                }
            }

            switch (tokens[1]) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String type = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, type);
                    List<Pokemon> pokemons = person.getPokemons();
                    pokemons.add(pokemon);
                    person.setPokemons(pokemons);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String birthday = tokens[3];
                    Parents parents = new Parents(parentName, birthday);
                    List<Parents> currentParents = person.getParents();
                    currentParents.add(parents);
                    person.setParents(currentParents);
                    break;
                case "children":
                    String childName = tokens[2];
                    String birthdayChild = tokens[3];
                    Children children = new Children(childName, birthdayChild);
                    List<Children> currentChildren = person.getChildren();
                    currentChildren.add(children);
                    person.setChildren(currentChildren);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int speed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carModel, speed);
                    person.setCar(car);
                    break;
            }

            if (!hasPerson) {
                people.add(person);
            }
            input = scanner.nextLine();
        }

        //TonchoTonchev
        //Company:
        //Car:
        //Trabant 30
        //Pokemon:
        //Electrode Electricity
        //Parents:
        //Children:

        String targetName = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        for (Person person : people) {
            if (person.getName().equals(targetName)) {
                sb.append(person.getName()).append(System.lineSeparator());
                sb.append("Company:").append(System.lineSeparator());
                if (person.getCompany() != null) {
                    sb.append(person.getCompany().toString()).append(System.lineSeparator());
                }
                sb.append("Car:").append(System.lineSeparator());
                if (person.getCar() != null) {
                    sb.append(person.getCar().toString()).append(System.lineSeparator());
                }

                sb.append("Pokemon:").append(System.lineSeparator());
                for (Pokemon pokemon : person.getPokemons()) {
                    sb.append(pokemon.toString()).append(System.lineSeparator());
                }
                sb.append("Parents:").append(System.lineSeparator());
                for (Parents parent : person.getParents()) {
                    sb.append(parent.toString()).append(System.lineSeparator());
                }
                sb.append("Children:").append(System.lineSeparator());
                for (Children child : person.getChildren()) {
                    sb.append(child.toString()).append(System.lineSeparator());
                }
                System.out.println(sb.toString());
                break;
            }
        }


    }
}








