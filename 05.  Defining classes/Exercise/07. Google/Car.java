package Google;

public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        return this.model + " " + this.speed;

    }
}

