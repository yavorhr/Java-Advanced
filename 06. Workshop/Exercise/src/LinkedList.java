import java.util.function.Consumer;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {

    }

    private static class Node {
        private int element;
        private Node next;
        private Node prev;

        private Node(int element) {
            this.element = element;
        }
    }

    public void addFirst(int element) {
        Node newNode = new Node(element);

        if (this.head != null) {
            newNode.next = this.head;
            this.head.prev = newNode;
        }

        this.head = newNode;

        if (this.isEmpty()) {
            this.tail = this.head;
        }
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int get(int index) {
        validateIndex(index);

        Node current = this.head;
        int result = 0;

        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                result = current.element;
                break;
            }
            currentIndex++;
            current = current.next;
        }
        return result;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove from empty LinkedList!");
        }
        int result = this.head.element;

        this.head = this.head.next;
        if (this.size > 1) {
            this.head.prev = null;
        }
        this.size--;

        if (this.isEmpty()) {
            this.head = this.tail = null;
        }

        return result;
    }

    public int removeLast() {
        if (this.size < 2) {
            return this.removeFirst();
        }

        int result = this.tail.element;
        this.tail = this.tail.prev;
        this.tail.next = null;

        this.size--;
        return result;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = this.head;

        while (current != null) {
            consumer.accept(current.element);
            current = current.next;
        }
    }

    public int[] toArray() {
        int[] arr = new int[this.size];

        Node current = this.head;

        int index = 0;
        while (current != null) {
            arr[index++] = current.element;
            current = current.next;
        }
        return arr;
    }

    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        Node newNode = new Node(element);

        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;

        this.size++;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IllegalArgumentException("Index " + index + " was out of structures bound with size " + this.size());
        }
    }

}
