public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }


    @Override
    public int compareTo(Person otherPerson) {
        int result = this.name.compareTo(otherPerson.name);
        if (result == 0) {
            result = Integer.compare(this.age, otherPerson.age);
            if (result == 0) {
                result = this.town.compareTo(otherPerson.town);
            }
        }
        return result;
    }
}
