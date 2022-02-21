import java.nio.file.LinkPermission;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double consumption = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuel, consumption);
            cars.put(model, car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String model = input.split("\\s+")[1];
            int distanceToDrive = Integer.parseInt(input.split("\\s+")[2]);
            // по модел извикваме класа Car
            Car carToDrive = cars.get(model);

            if (!carToDrive.drive(distanceToDrive)) {
                // не можем да караме
                System.out.println("Insufficient fuel for the drive");
            }
            input = scanner.nextLine();
        }
        //за всяка кола от values на мапа Cars, което са всички коли от класа Cars
        for (Car car : cars.values()) {
            //AudiA4 23 0.3
            System.out.println(car.toString());
        }

    }
}
