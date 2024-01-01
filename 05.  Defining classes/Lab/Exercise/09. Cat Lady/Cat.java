public class Cat {
    private String name;
    private double specialCharacteristic;

    public Cat(String name, double specialCharacteristic) {
        this.name = name;
        this.specialCharacteristic = specialCharacteristic;
    }

    public String getName() {
        return name;
    }

    public Cat setName(String name) {
        this.name = name;
        return this;
    }

    public double getSpecialCharacteristic() {
        return specialCharacteristic;
    }

    public Cat setSpecialCharacteristic(int specialCharacteristic) {
        this.specialCharacteristic = specialCharacteristic;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", getName(),getSpecialCharacteristic());
    }
}
