import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.getCount()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public int getCount() {
        return this.data.size();
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream()
                .filter(p ->
                        p.getName().equals(name) && p.getOwner().equals(owner))
                .collect(Collectors.toList()).get(0);
    }

    public Pet getOldestPet() {
        return this.data.stream()
                .sorted((f, s) -> Integer.compare(s.getAge(), f.getAge()))
                .collect(Collectors.toList()).get(0);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The clinic has the following patients:\n");
        this.data.forEach(p -> sb.append(String.format("%s %s", p.getName(), p.getOwner())).append(System.lineSeparator()));

        return sb.toString();
    }
}
