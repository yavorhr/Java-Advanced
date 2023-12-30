public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power, displacement);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
        this.displacement = 0;
    }

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    public String getModel() {
        return model;
    }

    public Engine setModel(String model) {
        this.model = model;
        return this;
    }

    public int getPower() {
        return power;
    }

    public Engine setPower(int power) {
        this.power = power;
        return this;
    }

    public int getDisplacement() {
        return displacement;
    }

    public Engine setDisplacement(int displacement) {
        this.displacement = displacement;
        return this;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public Engine setEfficiency(String efficiency) {
        this.efficiency = efficiency;
        return this;
    }

    @Override
    public String toString() {
        return String.format("""
                        Power: %d
                        Displacement: %s
                        Efficiency: %s
                        """
                , getPower(), this.displacement == 0 ? "n/a" : getDisplacement(), getEfficiency());
    }
}
