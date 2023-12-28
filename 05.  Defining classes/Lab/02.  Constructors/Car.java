public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand, String model, int horsePower) {
        this(brand, model);
        this.horsePower = horsePower;
    }

    public Car(String brand, String model) {
        this(brand);
        this.model = model;
        this.horsePower = -1;
    }

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Car setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP", getBrand(), getModel(), getHorsePower());
    }

    public String carInfo() {
        return toString();
    }
}
