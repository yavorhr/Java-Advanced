public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
        this.weight = 0;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public Car setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Car setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "%s:\n" +
                        "%s:\n" +
                        "%s" +
                        "Weight: %s\n" +
                        "Color: %s"
                , getModel(), getEngine().getModel(), getEngine().toString(), this.weight == 0 ? "n/a" : getWeight(), getColor());
    }
}
