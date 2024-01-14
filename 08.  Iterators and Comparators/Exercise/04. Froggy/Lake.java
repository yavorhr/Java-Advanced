import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    private int[] numbers;

    public Lake(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public Lake setNumbers(int[] numbers) {
        this.numbers = numbers;
        return this;
    }

    private class Frog implements Iterator<Integer> {
        private int index;

        public Frog() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < numbers.length;
        }

        @Override
        public Integer next() {
            int lastEvenIndex = numbers.length % 2 == 0 ? numbers.length - 2 : numbers.length - 1;
            if (this.index == lastEvenIndex) {
                int element = numbers[lastEvenIndex];
                this.index = 1;
                return element;
            }
            int element = numbers[this.index];
            this.index += 2;
            return element;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
}
