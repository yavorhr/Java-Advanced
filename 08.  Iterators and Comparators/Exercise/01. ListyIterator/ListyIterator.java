import java.util.ArrayList;
import java.util.List;

public class ListIterator {
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

}

