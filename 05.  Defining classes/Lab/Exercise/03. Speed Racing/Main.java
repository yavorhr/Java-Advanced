import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, Car> carsMap = new LinkedHashMap<>();

        while (n > 0) {
            String[] tokens = scanner.nextLine().split(" ");

            addCarToMap(carsMap, tokens);

            n--;
        }

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            String model = tokens[1];
            int distance = Integer.parseInt(tokens[2]);

            Car car = carsMap.get(model);
            driveDistance(distance, car);

            input = scanner.nextLine();
        }

        printCarsMap(carsMap);
    }

    private static void printCarsMap(Map<String, Car> carsMap) {
        carsMap.values().forEach(System.out::println);
    }

    private static void driveDistance(int distance, Car car) {
        boolean canDrive = car.drive(distance);

        if (!canDrive){
            System.out.println("Insufficient fuel for the drive");
        }
    }

    private static void addCarToMap(Map<String, Car> carsMap, String[] tokens) {
        String model = tokens[0];
        double fuelLiters = Integer.parseInt(tokens[1]);
        double fuelCostPerKm = Double.parseDouble(tokens[2]);

        Car car = new Car(model, fuelLiters, fuelCostPerKm);
        carsMap.put(model, car);
    }
}


