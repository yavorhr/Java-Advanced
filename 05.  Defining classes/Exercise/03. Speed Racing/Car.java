public class Car {
    //Model, fuel amount, fuel cost for 1 kilometer and distance traveled.
    private String model;
    private double fuel;
    private double consumption;
    private int distance;


    public Car(String model, double fuel, double consumption) {
        this.model = model;
        this.fuel = fuel;
        this.consumption = consumption;
        this.distance = 0;
    }

    public boolean drive(int distanceToDrive) {
        //растояние -> колко гориво ще ни отнеме
        double needFuel = distanceToDrive * this.consumption;
        if (needFuel <= this.fuel) {
            //изминаваме разстоянието;
            this.distance += distanceToDrive;
            this.fuel -= needFuel;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        // AudiA4 23 0.3
        return String.format("%s %.2f %d", this.model, this.fuel, this.distance);
    }
}
