import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }

    public Car getLatestCar() {
        return this.data.stream()
                .sorted((f, s) ->
                        Integer.compare(s.getYear(), f.getYear()))
                .collect(Collectors.toList())
                .get(0);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().
                filter(c ->
                        c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
                .collect(Collectors.toList())
                .get(0);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("The cars are parked in %s:\n", this.type));

        this.data.forEach(c -> sb.append(c.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
