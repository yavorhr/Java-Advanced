import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public List<T> getElements() {
        return elements;
    }

    public Box<T> setElements(List<T> elements) {
        this.elements = elements;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        getElements().forEach(e -> sb.append(String.format("%s: %s\n", e.getClass(), e)));
        return sb.toString();
    }
}
