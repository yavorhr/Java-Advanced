public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public int getSpeed() {
        return speed;
    }

    public Car setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %d", getModel(), getSpeed());
    }
}
