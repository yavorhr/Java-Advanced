import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Person setCompany(Company company) {
        this.company = company;
        return this;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public Person setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
        return this;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public Person setParents(List<Parent> parents) {
        this.parents = parents;
        return this;
    }

    public List<Child> getChildren() {
        return children;
    }

    public Person setChildren(List<Child> children) {
        this.children = children;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public Person setCar(Car car) {
        this.car = car;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getName()).append(System.lineSeparator());

        sb.append("Company:").append(System.lineSeparator());
        if (getCompany() != null) {
            sb.append(getCompany().toString()).append(System.lineSeparator());
        }

        sb.append("Car:").append(System.lineSeparator());
        if (getCar() != null) {
            sb.append(getCar().toString()).append(System.lineSeparator());
        }

        sb.append("Pokemon:").append(System.lineSeparator());
        if (getPokemons().size() != 0) {
            getPokemons().forEach(p -> sb.append(p.toString()).append(System.lineSeparator()));
        }

        sb.append("Parents:").append(System.lineSeparator());
        if (getParents().size() != 0) {
            getParents().forEach(p -> sb.append(p.toString()));
        }

        sb.append("Children:").append(System.lineSeparator());
        if (getChildren().size() != 0) {
            getChildren().forEach(p -> sb.append(p.toString()));
        }
        return sb.toString();
    }
}
