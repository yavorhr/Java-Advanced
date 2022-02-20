package Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new LinkedList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens.length == 3) {
                String model = tokens[0];
                String brand = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                Car car = new Car(model, brand, horsePower);
                cars.add(car);
            } else if (tokens.length == 1) {
                String model = tokens[0];
                Car car = new Car(model);
                cars.add(car);
            }
        }
        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }
}








