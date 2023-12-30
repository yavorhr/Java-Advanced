public class Tire {
    private double pressure;
    private int age;

    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }

    public Tire setPressure(double pressure) {
        this.pressure = pressure;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Tire setAge(int age) {
        this.age = age;
        return this;
    }

    public boolean isFlat() {
        if (this.pressure < 1.00) {
            return true;
        }
        return false;
    }
}
