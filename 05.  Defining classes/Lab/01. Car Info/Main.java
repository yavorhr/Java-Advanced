import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
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
        String brand = tokens[0];
        String model = tokens[1];
        int hp = Integer.parseInt(tokens[2]);

        Car car = new Car(brand,model,hp);
        return car;
    }
}

