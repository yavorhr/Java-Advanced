import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public void swap(int first, int second) {
        T firstElement = this.values.get(first);
        T secondElement = this.values.get(second);
        for (int i = 0; i < values.size(); i++) {
            values.set(first, secondElement);
            values.set(second, firstElement);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : this.values) {
            sb.append(String.format("%s: %s", value.getClass().getName(), value)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}



