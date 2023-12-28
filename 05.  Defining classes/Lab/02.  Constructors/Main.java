import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        while (n > 0) {
            Car car = getCar(scanner);

            printCar(car);

            n--;
        }
    }

    private static void printCar(Car car) {
        System.out.println(car.carInfo());
    }

    private static Car getCar(Scanner scanner) {
        String[] tokens = scanner.nextLine().split(" ");
        String model = tokens[0];

        Car car = null;

        if (tokens.length == 1) {
            car = new Car(model);
        } else if (tokens.length == 2) {
            String brand = tokens[1];
            car = new Car(model, brand);
        } else if (tokens.length == 3) {
            String brand = tokens[1];
            int hp = Integer.parseInt(tokens[2]);
            car = new Car(model, brand, hp);
        }

        return car;
    }
}

