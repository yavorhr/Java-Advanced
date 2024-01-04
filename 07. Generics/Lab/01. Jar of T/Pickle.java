public class Pickle {

    private String origin;

    public Pickle(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public Pickle setOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    @Override
    public String toString() {
        return getOrigin();
    }
}
