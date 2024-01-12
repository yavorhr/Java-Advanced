import java.util.function.Consumer;

public class Stack {
    private Node top;
    private int size;

    public Stack() {
    }

    private static class Node {
        private int element;
        private Node prev;

        private Node(int element) {
            this.element = element;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(int element) {
        Node newNode = new Node(element);
        //add for first time
        if (this.top == null) {
            this.top = newNode;
        } else {
            newNode.prev = this.top;
            this.top = newNode;
        }
        this.size++;
    }

    public int pop() {
        ensureNonEmpty();
        int result = this.top.element;

        this.top = this.top.prev;
        this.size--;

        return result;
    }

    private void ensureNonEmpty() {
        if (this.top == null) {
            throw new IllegalStateException("Empty stack");
        }
    }

    public int peak() {
        ensureNonEmpty();
        return this.top.element;
    }

//    public void forEach(Consumer<Integer> consumer) {
//        Node current = this.top;
//
//        while (current != null) {
//            consumer.accept(current.element);
//            current = current.prev;
//        }
//    }
}
