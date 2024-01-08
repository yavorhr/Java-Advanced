import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return elements;
    }

    public Box<T> setElements(List<T> elements) {
        this.elements = elements;
        return this;
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public int getSize() {
        return this.elements.size();
    }

    public int getGreaterCountOfElements(T element) {
        return (int) this.elements.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        getElements().forEach(e -> sb.append(String.format("%s: %s\n", e.getClass(), e)));
        return sb.toString();
    }
}
