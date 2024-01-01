public class Engine {
    private int speed;
    private int power;

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    public Engine setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public int getPower() {
        return power;
    }

    public Engine setPower(int power) {
        this.power = power;
        return this;
    }
}
