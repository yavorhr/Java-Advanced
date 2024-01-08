import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> arrayList;

    public CustomList() {
        this.arrayList = new ArrayList<>();
    }

    public List<T> getArrayList() {
        return arrayList;
    }

    public CustomList<T> setArrayList(List<T> arrayList) {
        this.arrayList = arrayList;
        return this;
    }

    public void add(T element) {
        this.arrayList.add(element);
    }

    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    public T remove(int index) {
        validateIndex(index);
        return this.arrayList.remove(index);
    }

    public boolean contains(T element) {
        return this.arrayList.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        validateIndex(firstIndex);
        validateIndex(secondIndex);

        T firstElement = this.arrayList.get(firstIndex);
        T secondElement = this.arrayList.get(secondIndex);

        this.arrayList.set(firstIndex, secondElement);
        this.arrayList.set(secondIndex, firstElement);
    }

    public int countGreaterThan(T element) {
        return (int) this.arrayList.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Collection is empty!");
        }

        T maxElement = this.arrayList.get(0);

        for (T element : this.arrayList) {
            if (element.compareTo(maxElement) > 0) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    public T getMin() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Collection is empty!");
        }

        T minElement = this.arrayList.get(0);

        for (T element : this.arrayList) {
            if (element.compareTo(minElement) < 0) {
                minElement = element;
            }
        }
        return minElement;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.arrayList.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bound exception!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.arrayList.forEach(System.out::println);

        return sb.toString();
    }
}
