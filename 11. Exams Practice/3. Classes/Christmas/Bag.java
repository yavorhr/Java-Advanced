import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> presents;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.presents = new ArrayList<>();
    }

    public String getColor() {
        return this.color;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int count() {
        return this.presents.size();
    }

    public void add(Present present) {
        if (this.presents.size() < this.capacity) {
            this.presents.add(present);
        }
    }

    public boolean remove(String name) {
        return this.presents.removeIf(p -> p.getName().equals(name));
    }

    public Present heaviestPresent() {
        return
                this.presents.stream()
                        .sorted((f, s) ->
                                Double.compare(s.getWeight(), f.getWeight())).collect(Collectors.toList()).get(0);
    }

    public Present getPresent(String name) {
        return this.presents.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("%s bag contains:\n", this.color));

        this.presents.forEach(p -> sb.append(p.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
