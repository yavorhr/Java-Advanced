package raw;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires = new ArrayList<>();

    public Car(String model,Engine engine, Cargo cargo, List<Tire> tires) {
        this.model=model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public String getModel(){
        return this.model;
    }

    public Engine getEngine(){
        return this.engine;
    }

    //about model, engine, cargo and a collection of exactly 4 tires
}
