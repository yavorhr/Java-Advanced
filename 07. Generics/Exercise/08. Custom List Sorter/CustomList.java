import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public void remove(int index) {
        if (index < 0 || index >= this.values.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        this.values.remove(index);
    }

    public boolean contains(T element) {
        return this.values.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        validateIndexes(firstIndex, secondIndex);
        //Collections.swap (indexOne, indexTwo);
        T firstElement = this.values.get(firstIndex);
        T secondElement = this.values.get(secondIndex);
        this.values.set(firstIndex, secondElement);
        this.values.set(secondIndex, firstElement);
    }

    private void validateIndexes(int indexOne, int indexTwo) {
        if (indexOne < 0 || indexOne >= this.values.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (indexTwo < 0 || indexTwo >= this.values.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public int countGreaterThan(T element) {
        return (int) this.values.stream().filter(e -> e.compareTo(element) > 0).count();

    }

    public T getMax() {
        //Collections.max(this.list)
        if (this.values.isEmpty()) {
            throw new IllegalStateException("Empty list!!!");
        }

        T maxElement = this.values.get(0);
        for (int i = 0; i < this.values.size(); i++) {
            T currentE = this.values.get(i);
            if (currentE.compareTo(maxElement) > 0) {
                maxElement = currentE;
            }
        }
        return maxElement;
    }

    public T getMin() {
        if (this.values.isEmpty()) {
            throw new IllegalStateException("Empty list!!!");
        }

        T minElement = this.values.get(0);
        for (int i = 0; i < this.values.size(); i++) {
            T currentE = this.values.get(i);
            if (currentE.compareTo(minElement) < 0) {
                minElement = currentE;
            }
        }
        return minElement;
    }

    public int size() {
        return this.values.size();
    }

    public T get (int index) {
        return this.values.get(index);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.values) {
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}



