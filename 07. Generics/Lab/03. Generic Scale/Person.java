public class Person implements Comparable<Person> {
    String name;
    int weight;

    public Person(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return getName() + " - " + getWeight() + " kg";
    }
}
