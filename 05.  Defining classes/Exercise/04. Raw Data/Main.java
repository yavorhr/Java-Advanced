package raw;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        LinkedList<Car> cars = new LinkedList<>();
        Set<Car> output = new HashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            //ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4
            //Model>
            // <EngineSpeed> <EnginePower>
            // <CargoWeight> <CargoType>
            // <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>"
            String model = input[0];

            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>();
            for (int j = 5; j < 12; j += 2) {
                double tirePressure = Double.parseDouble(input[j]);
                int tireAge = Integer.parseInt(input[j + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String fragileOrFlammable = scanner.nextLine();
        if (fragileOrFlammable.equals("fragile")) {
            for (Car car : cars) {
                car.getTires().forEach(tire -> {
                    if (tire.isFlat() && car.getCargo().getCargoType().equals("fragile")) {
                        output.add(car);
                    }
                });
            }
        } else {
            for (Car car : cars) {
                if (car.getCargo().getCargoType().equals("flamable") && car.getEngine().getEnginePower() > 250) {
                    output.add(car);
                }
            }
        }
        for (Car car : output) {
            System.out.println(car.getModel());
        }
    }
}
