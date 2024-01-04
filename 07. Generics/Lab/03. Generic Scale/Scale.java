public class Scale<E extends Comparable<E>> {
    private E left;
    private E right;

    public Scale(E left, E right) {
        this.left = left;
        this.right = right;
    }

    public E getHeavier() {
        int result = this.left.compareTo(this.right);
        if (result > 0) {
            return this.left;
        }

        if (result == 0) {
            return null;
        }

        return this.right;
    }
}
