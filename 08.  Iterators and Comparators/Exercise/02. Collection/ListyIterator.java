import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterator implements Iterable<String> {
    private List<String> data;
    private int index;

    public ListIterator(List<String> list) {
        this.data = list;
        setIndex();
    }

    public ListIterator() {
        this.data = new ArrayList<>();
        setIndex();
    }

    public boolean move() {
        if (this.index < this.data.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index < this.data.size() - 1;
    }

    public String print() {
        if (this.index == -1) {
            return "Invalid Operation!";
        }
        return this.data.get(this.index);
    }

    private void setIndex() {
        if (this.data.size() != 0) {
            this.index = 0;
        } else {
            this.index = -1;
        }
    }

    private class InnerIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return this.index <= data.size() - 1;
        }

        @Override
        public String next() {
            return data.get(this.index++);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new InnerIterator();
    }
}

