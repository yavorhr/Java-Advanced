public class Cargo {
    private String type;
    private int weight;

    public Cargo(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public Cargo setType(String type) {
        this.type = type;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Cargo setWeight(int weight) {
        this.weight = weight;
        return this;
    }
}
