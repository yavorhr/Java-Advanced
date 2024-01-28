import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public int count() {
        return this.data.size();
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(r -> r.getName().equals(name));
    }

    public boolean removeSpecies(String species) {
        return this.data.removeIf(r -> r.getName().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = null;
        for (Rabbit currRabbit : this.data) {
            if (currRabbit.getName().equals(name)) {
                currRabbit.setAvailable(false);
                rabbit = currRabbit;
                break;
            }
        }
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> soldRabbits = new ArrayList<>();

        this.data.forEach(r -> {
            if (r.getSpecies().equals(species)) {
                r.setAvailable(false);
                soldRabbits.add(r);
            }
        });
        return soldRabbits;
    }


    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Rabbits available at %s:\n", this.name));
        this.data.stream().filter(Rabbit::isAvailable).forEach(r -> sb.append(r).append(System.lineSeparator()));

        return sb.toString();
    }
}
