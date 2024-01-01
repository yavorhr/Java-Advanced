public class Car {
    private String model;
    private double fuelLiters;
    private double fuelCostPerKm;
    private int distance;

    public Car(String model, double fuelLiters, double fuelCostPerKm) {
        this.model = model;
        this.fuelLiters = fuelLiters;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distance = 0;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public double getFuelLiters() {
        return fuelLiters;
    }

    public Car setFuelLiters(double fuelLiters) {
        this.fuelLiters = fuelLiters;
        return this;
    }

    public double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    public Car setFuelCostPerKm(double fuelCostPerKm) {
        this.fuelCostPerKm = fuelCostPerKm;
        return this;
    }

    public int getDistance() {
        return distance;
    }

    public Car setDistance(int distance) {
        this.distance = distance;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", getModel(), getFuelLiters(), getDistance());
    }

    public boolean drive(int distanceToDrive) {
        double possibleDistance = this.fuelLiters / this.fuelCostPerKm;
        if (possibleDistance >= distanceToDrive) {
            this.distance += distanceToDrive;
            this.fuelLiters -= distanceToDrive * fuelCostPerKm;
            return true;
        }
        return false;
    }
}
