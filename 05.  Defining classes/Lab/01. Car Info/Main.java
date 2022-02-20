import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Car car = new Car();
            car.setBrand(tokens[0]);
            car.setModel(tokens[1]);
            car.setHorsePower(Integer.parseInt(tokens[2]));

            System.out.println(String.format("The car is: %s %s - %d HP.",car.getBrand(),car.getModel(),car.getHorsePower()));
        }



    }
}






