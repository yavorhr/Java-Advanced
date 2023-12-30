import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        List<Car> carsList = new LinkedList<>();

        while (n > 0) {
            String[] parts = scanner.nextLine().split(" ");
            String carModel = parts[0];
            int engineSpeed = Integer.parseInt(parts[1]);
            int enginePower = Integer.parseInt(parts[2]);
            int cargoWeight = Integer.parseInt(parts[3]);
            String cargoType = parts[4];

            List<Tire> tires = getTires(parts);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoType, cargoWeight);
            Car car = new Car(carModel, engine, cargo, tires);
            carsList.add(car);

            n--;
        }

        String printCriteria = scanner.nextLine();

        if (printCriteria.equals("fragile")) {
            carsList
                    .stream()
                    .filter(c -> c.getCargo().getType().equals(printCriteria))
                    .filter(c -> c.getTires().stream().anyMatch(Tire::isFlat))
                    .forEach(c -> System.out.println(c.getModel()));
        } else if (printCriteria.equals("flamable")) {
            carsList.stream()
                    .filter(c -> c.getCargo().getType().equals(printCriteria))
                    .filter(c -> c.getEngine().getPower() > 250)
                    .forEach(c -> System.out.println(c.getModel()));
        }
    }

    private static List<Tire> getTires(String[] parts) {
        List<Tire> tires = new ArrayList<>();

        for (int i = 5; i <= 12; i+=2) {
            double tirePressure = Double.parseDouble(parts[i]);
            int tireAge = Integer.parseInt(parts[i + 1]);

            Tire tire = new Tire(tirePressure, tireAge);
            tires.add(tire);
        }
        return tires;
    }
}


