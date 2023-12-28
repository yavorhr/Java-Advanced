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
        System.out.printf("The car is: %s %s - %d HP%n", car.getBrand(), car.getModel(), car.getHorsePower());
    }

    private static Car getCar(Scanner scanner) {
        String[] tokens = scanner.nextLine().split(" ");
        String brand = tokens[0];
        String model = tokens[1];
        int hp = Integer.parseInt(tokens[2]);

        Car car = new Car();

        car.setBrand(brand);
        car.setModel(model);
        car.setHorsePower(hp);

        return car;
    }
}

