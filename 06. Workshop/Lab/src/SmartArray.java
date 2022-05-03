import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] elements;
    private int size;

    public SmartArray() {
        this.elements = new int[INITIAL_CAPACITY];
    }

    public void add(int element) {
        if (this.size == this.elements.length) {
            this.elements = grow();
        }
        this.elements[this.size] = element;
        this.size++;
    }

    public int get(int index) {
        validateIndex(index);
        return this.elements[index];
    }

    public int remove(int index) {
        validateIndex(index);

        int element = this.elements[index];

        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.elements[this.size - 1] = 0;

        this.size--;

        if (this.elements.length > 4 && this.size < this.elements.length / 4) {
            this.elements = shrink();
        }
        return element;
    }

    //to reduce memory if elements[index] = 0;
    private int[] shrink() {
        int[] newElements = new int[this.elements.length / 2];

        //System.arraycopy(this.elements, 0, newElements, 0, newElements.length);
        for (int i = 0; i < newElements.length; i++) {
            newElements[i] = this.elements[i];
        }
        return newElements;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        validateIndex(index);

        int lastElement = this.elements[this.size - 1];

        for (int i = this.size - 1; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;
        this.add(lastElement);
    }

    //Consumer is functional interface.
    // In the example, the Consumer will be the method, which we apply to each element (println() for example).
    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.elements[i]);
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds" + "for size " + this.size);
        }
    }

    private int[] grow() {
        int[] newElements = new int[this.size * 2];

        //System.arraycopy(this.elements, 0, newElements, 0, this.elements.length) -> better approach than the below copy of arrays
        for (int i = 0; i < this.elements.length; i++) {
            newElements[i] = this.elements[i];
        }
        return newElements;
    }
}
